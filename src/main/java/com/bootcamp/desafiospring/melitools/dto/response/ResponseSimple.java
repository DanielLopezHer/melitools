package com.bootcamp.desafiospring.melitools.dto.response;

import org.springframework.http.HttpStatus;

public class ResponseSimple {
    private HttpStatus status;
    private String message;

    public ResponseSimple() { }

    public ResponseSimple(String message, HttpStatus status) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
