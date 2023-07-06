package ru.sber.user.job.service.exception;

public class RequestIncorrectException extends RuntimeException {
    public RequestIncorrectException() {
    }

    public RequestIncorrectException(String message) {
        super(message);
    }
}
