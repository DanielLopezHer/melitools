package com.bootcamp.desafiospring.melitools.dto.response;

import org.springframework.http.HttpStatus;

public class ResponseSimpleDTO {
    private HttpStatus status;
    private String message;

    public ResponseSimpleDTO() { }

    public ResponseSimpleDTO(String message, HttpStatus status) {
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
