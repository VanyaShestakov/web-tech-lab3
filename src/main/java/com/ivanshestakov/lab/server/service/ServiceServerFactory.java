package com.ivanshestakov.lab.server.service;

import com.ivanshestakov.lab.server.repository.StudentServerRepository;
import com.ivanshestakov.lab.server.service.impl.StudentServerServiceImpl;

public class ServiceServerFactory {
    private static final ServiceServerFactory instance = new ServiceServerFactory();

    private ServiceServerFactory() {}

    public StudentServerService getStudentService(StudentServerRepository studentDAO) {

        return new StudentServerServiceImpl(studentDAO);
    }

    public static ServiceServerFactory getInstance() {
        return instance;
    }
}