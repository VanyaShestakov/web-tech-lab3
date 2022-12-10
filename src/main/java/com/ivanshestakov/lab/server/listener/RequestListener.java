package com.ivanshestakov.lab.server.listener;

import com.ivanshestakov.lab.client.dto.StudentRequestDto;
import com.ivanshestakov.lab.client.dto.StudentResponseDto;
import com.ivanshestakov.lab.server.controller.ClientController;
import com.ivanshestakov.lab.server.repository.factory.ServerRepositoryFactory;
import com.ivanshestakov.lab.server.service.StudentServerService;
import com.ivanshestakov.lab.server.service.impl.StudentServerServiceImpl;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RequestListener extends Thread {
    private final ObjectInputStream in;
    private final ObjectOutputStream out;
    private final ClientController controller;

    public RequestListener(Socket socket) throws IOException {
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
        StudentServerService service = new StudentServerServiceImpl(ServerRepositoryFactory.getInstance().getStudentDAO());
        this.controller = new ClientController(service);
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                StudentRequestDto request = (StudentRequestDto) this.in.readObject();
                StudentResponseDto response = switch (request.getRequest()) {
                    case CREATE -> this.controller.create(request);
                    case GET -> this.controller.get(request);
                    case GET_ALL -> this.controller.getAll();
                    case EDIT -> this.controller.edit(request);
                    case REGISTER -> this.controller.register(request);
                    case LOGIN -> this.controller.login(request);
                    default -> this.controller.notFound();
                };

                this.out.writeObject(response);
                this.out.flush();
            }

        } catch (EOFException ignored) {

        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("Failed read: %s%n", e.getMessage());
        }
    }
}
