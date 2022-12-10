package com.ivanshestakov.lab.server.runner;

import com.ivanshestakov.lab.server.socket.Server;

public class ServerRunner {

    public static void main(String[] args) {
        Server server = new Server(5555);
        server.start();
        try {
            server.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}