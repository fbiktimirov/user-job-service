package ru.sber.user.job.service.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.sber.user.job.service.controller.UserJobInfoController;
import ru.sber.user.job.service.exception.DataAlreadyExistException;
import ru.sber.user.job.service.exception.DataNotFoundException;
import ru.sber.user.job.service.exception.RequestIncorrectException;

@ControllerAdvice(basePackageClasses = UserJobInfoController.class)
public class UserJobInfoControllerAdvice {

    @ExceptionHandler(DataAlreadyExistException.class)
    public ResponseEntity<?> handleDataAlreadyExistException() {
        return ResponseEntity.status(409).build();
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> handleDataNotFoundException() {
        return ResponseEntity.status(404).build();
    }

    @ExceptionHandler(RequestIncorrectException.class)
    public ResponseEntity<?> handleRequestIncorrectException() {
        return ResponseEntity.status(400).build();
    }
}
