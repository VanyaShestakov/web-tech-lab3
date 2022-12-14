package com.ivanshestakov.lab.client.presentation.model;

import com.ivanshestakov.lab.client.entity.Student;
import com.ivanshestakov.lab.client.service.StudentClientService;

import java.util.List;

public abstract class PresentationModel {
    protected StudentClientService studentService;
    public PresentationModel(StudentClientService studentService) {
        this.studentService = studentService;
    }

    public abstract List<Student> getItems();
}
