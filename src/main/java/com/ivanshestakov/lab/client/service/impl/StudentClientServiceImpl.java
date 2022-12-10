package com.ivanshestakov.lab.client.service.impl;

import com.ivanshestakov.lab.client.repository.StudentClientRepository;
import com.ivanshestakov.lab.client.entity.Student;
import com.ivanshestakov.lab.client.entity.User;
import com.ivanshestakov.lab.client.service.StudentClientService;

import java.util.List;

public class StudentClientServiceImpl implements StudentClientService {
    private final StudentClientRepository studentDAO;

    public StudentClientServiceImpl(StudentClientRepository studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public boolean edit(Student newValue) {
        return this.studentDAO.edit(newValue);
    }

    @Override
    public List<Student> getAll() {
        return this.studentDAO.getAll();
    }

    @Override
    public Student get(int id) {
        return this.studentDAO.get(id);
    }

    @Override
    public boolean create(Student student) {
        return this.studentDAO.create(student);
    }

    @Override
    public User register(User user) {
        return this.studentDAO.register(user);
    }

    @Override
    public User login(User user) {
        return this.studentDAO.login(user);
    }
}