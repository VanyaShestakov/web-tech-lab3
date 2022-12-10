package com.ivanshestakov.lab.client.repository.impl;

import com.ivanshestakov.lab.client.publisher.RequestPublisher;
import com.ivanshestakov.lab.client.repository.StudentClientRepository;
import com.ivanshestakov.lab.client.entity.Student;
import com.ivanshestakov.lab.client.entity.User;
import com.ivanshestakov.lab.client.enums.RequestType;
import com.ivanshestakov.lab.client.enums.ResponseType;
import com.ivanshestakov.lab.client.dto.StudentResponseDto;

import java.util.ArrayList;
import java.util.List;

public class StudentClientRepositoryImpl implements StudentClientRepository {
    private final RequestPublisher requestPublisher = new RequestPublisher("localhost", 5555);

    @Override
    public boolean edit(Student newValue) {
        StudentResponseDto response = requestPublisher
                .sendRequest(newValue, RequestType.EDIT);
        return (response != null)
                && (response.getResponse() == ResponseType.OK);
    }

    @Override
    public List<Student> getAll() {
        StudentResponseDto response = requestPublisher
                .sendRequest(null, RequestType.GET_ALL);

        if ((response != null)
                && (response.getResponse() == ResponseType.OK)
                && (response.getBody() instanceof ArrayList<?>)) {
            try {
                return (ArrayList<Student>) response.getBody();
            } catch (ClassCastException e) {
                return new ArrayList<>();
            }
        }

        return new ArrayList<>();
    }

    @Override
    public Student get(int id) {
        StudentResponseDto response = requestPublisher
                .sendRequest(id, RequestType.GET);

        if ((response != null)
                && (response.getResponse() == ResponseType.OK)
                && (response.getBody() instanceof Student student)) {
            return student;
        }

        return null;
    }

    @Override
    public boolean create(Student item) {
        StudentResponseDto response = requestPublisher
                .sendRequest(item, RequestType.CREATE);
        return (response != null)
                && (response.getResponse() == ResponseType.OK);
    }

    @Override
    public User register(User user) {
        StudentResponseDto response = requestPublisher
                .sendRequest(user, RequestType.REGISTER);
        if (response.getBody() instanceof User body) {
            return body;
        }

        return null;
    }

    @Override
    public User login(User user) {
        StudentResponseDto response = requestPublisher
                .sendRequest(user, RequestType.LOGIN);
        if (response.getBody() instanceof User body) {
            return body;
        }

        return null;
    }
}
