package com.ivanshestakov.lab.server.controller;

import com.ivanshestakov.lab.client.entity.Student;
import com.ivanshestakov.lab.client.entity.User;
import com.ivanshestakov.lab.client.enums.ResponseType;
import com.ivanshestakov.lab.client.dto.StudentRequestDto;
import com.ivanshestakov.lab.client.dto.StudentResponseDto;
import com.ivanshestakov.lab.server.service.StudentServerService;

import java.util.List;

public class ClientController {
    private final StudentServerService service;

    public ClientController(StudentServerService service) {
        this.service = service;
    }

    public StudentResponseDto create(StudentRequestDto request) {
        Student student;
        StudentResponseDto response = new StudentResponseDto();
        if (request.getBody() instanceof Student body) {
            student = body;
        } else {
            response.setResponse(ResponseType.ERROR);
            return response;
        }

        if (this.service.create(student)) {
            response.setResponse(ResponseType.OK);
        } else {
            response.setResponse(ResponseType.ERROR);
        }

        return response;
    }

    public StudentResponseDto edit(StudentRequestDto request) {
        Student student;
        StudentResponseDto response = new StudentResponseDto();
        if (request.getBody() instanceof Student body) {
            student = body;
        } else {
            response.setResponse(ResponseType.ERROR);
            return response;
        }

        if (this.service.edit(student)) {
            response.setResponse(ResponseType.OK);
        } else {
            response.setResponse(ResponseType.ERROR);
        }

        return response;
    }

    public StudentResponseDto getAll() {
        List<Student> students = this.service.getAll();
        StudentResponseDto response = new StudentResponseDto();
        if (students == null) {
            response.setResponse(ResponseType.ERROR);
            response.setBody(null);
        }
        else {
            response.setResponse(ResponseType.OK);
            response.setBody(students);
        }

        return response;
    }

    public StudentResponseDto get(StudentRequestDto request) {
        int id;
        StudentResponseDto response = new StudentResponseDto();
        if (request.getBody() instanceof Integer) {
            id = (int) request.getBody();
        } else {
            response.setResponse(ResponseType.ERROR);
            return response;
        }

        Student studentToSend = this.service.get(id);
        if (studentToSend != null) {
            response.setResponse(ResponseType.OK);
            response.setBody(studentToSend);
        } else {
            response.setResponse(ResponseType.ERROR);
        }

        return response;
    }

    public StudentResponseDto register(StudentRequestDto request) {
        User user;
        StudentResponseDto response = new StudentResponseDto();
        if (request.getBody() instanceof User body) {
            user = body;
        } else {
            response.setResponse(ResponseType.ERROR);
            return response;
        }

        User userResult = this.service.register(user);
        if (userResult != null) {
            response.setResponse(ResponseType.OK);
            response.setBody(userResult);
        } else {
            response.setResponse(ResponseType.ERROR);
        }

        return response;
    }

    public StudentResponseDto login(StudentRequestDto request) {
        User user;
        StudentResponseDto response = new StudentResponseDto();
        if (request.getBody() instanceof User body) {
            user = body;
        } else {
            response.setResponse(ResponseType.ERROR);
            return response;
        }

        User userResult = this.service.login(user);
        if (userResult != null) {
            response.setResponse(ResponseType.OK);
            response.setBody(userResult);
        } else {
            response.setResponse(ResponseType.ERROR);
        }

        return response;
    }

    public StudentResponseDto notFound() {
        StudentResponseDto response = new StudentResponseDto();
        response.setResponse(ResponseType.NOTFOUND);
        return response;
    }
}