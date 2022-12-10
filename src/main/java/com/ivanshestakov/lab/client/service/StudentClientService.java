package com.ivanshestakov.lab.client.service;

import com.ivanshestakov.lab.client.entity.Student;
import com.ivanshestakov.lab.client.entity.User;

import java.util.List;

public interface StudentClientService {

    boolean edit(Student newValue);

    List<Student> getAll();

    Student get(int id);

    boolean create(Student student);

    User register(User user);

    User login(User user);
}