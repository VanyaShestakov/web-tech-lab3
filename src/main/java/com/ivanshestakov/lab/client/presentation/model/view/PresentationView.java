package com.ivanshestakov.lab.client.presentation.model.view;

import com.ivanshestakov.lab.client.entity.User;
import com.ivanshestakov.lab.client.presentation.model.PresentationModel;
import com.ivanshestakov.lab.client.service.StudentClientService;

public abstract class PresentationView {
    protected PresentationModel model;
    protected StudentClientService studentService;
    protected User currentUser;

    protected PresentationView(StudentClientService studentService, User user) {
        this.studentService = studentService;
        this.currentUser = user;
    }

    public abstract void show();
    public abstract PresentationView getInput(String input);
}
