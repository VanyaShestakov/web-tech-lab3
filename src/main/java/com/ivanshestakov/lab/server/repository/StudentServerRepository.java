package com.ivanshestakov.lab.server.repository;

import com.ivanshestakov.lab.client.entity.Student;
import com.ivanshestakov.lab.client.entity.User;

import java.io.FileNotFoundException;
import java.util.List;

public interface StudentServerRepository {

    List<Student> getAll();

    Student get(int id);

    User userExists(User user);

    List<User> getAllUsers ();

    void rewriteUsers(List<User> users) throws FileNotFoundException;

    void rewriteStudents(List<Student> students) throws FileNotFoundException;
}
