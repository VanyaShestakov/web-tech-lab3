package com.ivanshestakov.lab.client.presentation.model.view;

import com.ivanshestakov.lab.client.entity.Student;
import com.ivanshestakov.lab.client.entity.User;
import com.ivanshestakov.lab.client.service.StudentClientService;

import java.util.List;

public class EditSelectView extends PresentationView{
    public EditSelectView(StudentClientService studentService, User user) {
        super(studentService, user);
    }

    @Override
    public void show() {
        List<Student> studentList = this.studentService.getAll();
        for (Student student : studentList) {
            System.out.println(student.getId() + ": " + student.getName());
        }

        System.out.println("Print 'quit' to exit");
        System.out.println("Select student id: ");
    }

    @Override
    public PresentationView getInput(String input) {
        if ("quit".equals(input)) {
            return new AdminView(this.studentService, this.currentUser);
        }

        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }

        return new EditView(this.studentService, this.currentUser, id);
    }
}