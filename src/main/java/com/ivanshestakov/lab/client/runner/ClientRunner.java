package com.ivanshestakov.lab.client.runner;

import com.ivanshestakov.lab.client.repository.factory.ClientRepositoryFactory;
import com.ivanshestakov.lab.client.presentation.Presentation;
import com.ivanshestakov.lab.client.service.ServiceClientFactory;

public class ClientRunner {
    public static void main(String[] args) {
        ServiceClientFactory factory = ServiceClientFactory.getInstance();
        ClientRepositoryFactory daoFactory = ClientRepositoryFactory.getInstance();
        Presentation presentation = new Presentation(factory.getStudentService(daoFactory.getStudentDAO()));
        presentation.show();
    }
}
