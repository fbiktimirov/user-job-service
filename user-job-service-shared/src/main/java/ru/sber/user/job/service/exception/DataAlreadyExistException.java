package ru.sber.user.job.service.exception;

public class DataAlreadyExistException extends RuntimeException {

    public DataAlreadyExistException(String message) {
        super(message);
    }
}
