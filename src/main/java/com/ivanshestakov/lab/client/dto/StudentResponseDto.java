package com.ivanshestakov.lab.client.dto;

import com.ivanshestakov.lab.client.enums.ResponseType;

import java.io.Serializable;

public class StudentResponseDto implements Serializable {
    private ResponseType ResponseType;
    private Object body;

    public ResponseType getResponse() {
        return ResponseType;
    }

    public void setResponse(ResponseType ResponseType) {
        this.ResponseType = ResponseType;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
