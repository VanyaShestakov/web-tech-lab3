package com.ivanshestakov.lab.client.repository.factory;

import com.ivanshestakov.lab.client.repository.StudentClientRepository;
import com.ivanshestakov.lab.client.repository.impl.StudentClientRepositoryImpl;

public class ClientRepositoryFactory {
    private static final ClientRepositoryFactory instance = new ClientRepositoryFactory();

    private ClientRepositoryFactory() {}

    public StudentClientRepository getStudentDAO() {
        return new StudentClientRepositoryImpl();
    }

    public static ClientRepositoryFactory getInstance() {
        return instance;
    }
}
