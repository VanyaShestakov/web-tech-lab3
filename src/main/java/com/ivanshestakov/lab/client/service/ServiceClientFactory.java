package com.ivanshestakov.lab.client.service;

import com.ivanshestakov.lab.client.repository.StudentClientRepository;
import com.ivanshestakov.lab.client.service.impl.StudentClientServiceImpl;

public class ServiceClientFactory {
    private static final ServiceClientFactory instance = new ServiceClientFactory();

    private ServiceClientFactory() {}

    public StudentClientService getStudentService(StudentClientRepository studentDAO) {

        return new StudentClientServiceImpl(studentDAO);
    }

    public static ServiceClientFactory getInstance() {
        return instance;
    }
}
