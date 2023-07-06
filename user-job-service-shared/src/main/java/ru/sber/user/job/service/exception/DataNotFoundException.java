package ru.sber.user.job.service.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException() {
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}
