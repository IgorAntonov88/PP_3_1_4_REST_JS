package com.example.pp_3_1_4_rest_js.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<IncorrectUserData> handleException (NotFoundUserException exception) {
        IncorrectUserData data = new IncorrectUserData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<IncorrectUserData> handleException (Exception exception) {
        IncorrectUserData data = new IncorrectUserData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
