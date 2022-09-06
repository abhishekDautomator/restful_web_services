package com.abhishek.rest.webservices.restful_web_services.errorHandler;

import java.time.LocalDateTime;

public class ErrorHandler {
    private LocalDateTime timeStamp;
    private String message;
    private Object statusCode;

    public ErrorHandler(LocalDateTime timeStamp, String message, Object statusCode) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "ErrorHandler{" +
                "timeStamp=" + timeStamp +
                ", message='" + message + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
