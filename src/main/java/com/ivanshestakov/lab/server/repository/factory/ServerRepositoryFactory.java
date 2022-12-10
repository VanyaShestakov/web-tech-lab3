package com.ivanshestakov.lab.server.repository.factory;

import com.ivanshestakov.lab.server.repository.StudentServerRepository;
import com.ivanshestakov.lab.server.repository.impl.StudentServerRepositoryImpl;

public class ServerRepositoryFactory {
    private static final ServerRepositoryFactory instance = new ServerRepositoryFactory();

    private ServerRepositoryFactory() {}

    public StudentServerRepository getStudentDAO() {
        return new StudentServerRepositoryImpl();
    }

    public static ServerRepositoryFactory getInstance() {
        return instance;
    }
}
