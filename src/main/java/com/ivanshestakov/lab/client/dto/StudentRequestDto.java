package com.ivanshestakov.lab.client.dto;

import com.ivanshestakov.lab.client.enums.RequestType;

import java.io.Serializable;

public class StudentRequestDto implements Serializable {
    private RequestType RequestType;
    private Object body;

    public RequestType getRequest() {
        return RequestType;
    }

    public void setRequest(RequestType RequestType) {
        this.RequestType = RequestType;
    }

    public Object getBody() {
        return this.body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
