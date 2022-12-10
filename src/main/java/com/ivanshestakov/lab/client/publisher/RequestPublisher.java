package com.ivanshestakov.lab.client.publisher;

import com.ivanshestakov.lab.client.enums.RequestType;
import com.ivanshestakov.lab.client.dto.StudentRequestDto;
import com.ivanshestakov.lab.client.dto.StudentResponseDto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RequestPublisher {
    private final String ip;
    private final int port;

    public RequestPublisher(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public StudentResponseDto sendRequest(Object body, RequestType type) {
        Socket client = null;
        try {
            try {
                client = new Socket(this.ip, this.port);

                ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream());
                ObjectInputStream is = new ObjectInputStream(client.getInputStream());

                StudentRequestDto req = new StudentRequestDto();
                req.setBody(body);
                req.setRequest(type);

                os.writeObject(req);
                os.flush();

                return (StudentResponseDto) is.readObject();

            } catch (IOException | ClassNotFoundException e) {
                System.out.printf("Error client: %s%n", e.getMessage());
            } finally {
                if ((client != null) && !client.isClosed()) {
                    client.close();
                }
            }

        } catch (IOException e) {
            System.out.printf("Error client: %s%n", e.getMessage());
        }

        return null;
    }
}