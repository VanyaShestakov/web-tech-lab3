package com.ivanshestakov.lab.client.presentation.model.view;

import com.ivanshestakov.lab.client.entity.User;
import com.ivanshestakov.lab.client.service.StudentClientService;

public class GuestView extends PresentationView{

    public GuestView(StudentClientService studentService, User user) {
        super(studentService, user);
    }

    @Override
    public void show() {
        System.out.println("1: Register\n2: Login\n3: exit");
    }

    @Override
    public PresentationView getInput(String input) {
        return switch (input) {
            case "1" -> new RegisterView(this.studentService, this.currentUser);
            case "2" -> new LoginView(this.studentService, this.currentUser);
            case "3" -> null;
            default -> throw new IllegalArgumentException();
        };
    }
}
