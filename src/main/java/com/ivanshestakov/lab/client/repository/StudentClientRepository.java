package com.ivanshestakov.lab.client.repository;

import com.ivanshestakov.lab.client.entity.Student;
import com.ivanshestakov.lab.client.entity.User;

import java.util.List;

public interface StudentClientRepository {

    boolean edit(Student newValue);

    List<Student> getAll();

    Student get(int id);

    boolean create(Student item);

    User register(User user);

    User login(User user);
}