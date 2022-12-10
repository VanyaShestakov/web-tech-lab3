package com.ivanshestakov.lab.client.presentation;

import com.ivanshestakov.lab.client.enums.Role;
import com.ivanshestakov.lab.client.entity.User;
import com.ivanshestakov.lab.client.presentation.model.view.GuestView;
import com.ivanshestakov.lab.client.presentation.model.view.PresentationView;
import com.ivanshestakov.lab.client.service.StudentClientService;

import java.util.Scanner;

public class Presentation {
    private PresentationView view;
    private User currentUser = null;
    public Presentation(StudentClientService studentService) {
        this.currentUser = new User();
        this.currentUser.setRole(Role.GUEST);
        this.view = new GuestView(studentService, this.currentUser);
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (this.view != null) {
            this.view.show();
            while (!getInput(scanner.nextLine())) {
                System.out.println("Invalid input");
            }
        }
    }

    private boolean getInput(String input) {
        try {
            this.view = this.view.getInput(input);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
