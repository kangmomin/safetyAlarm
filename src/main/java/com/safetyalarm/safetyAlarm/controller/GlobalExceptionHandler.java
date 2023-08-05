package com.safetyalarm.safetyAlarm.controller;

import com.safetyalarm.safetyAlarm.common.Result;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handleDataIntegrityViolationException(
            DataIntegrityViolationException ex) {

        return Result.error("bad data request", 400);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity UsernameNotFoundExceptionHandler(
            UsernameNotFoundException ex) {

        return Result.error(ex.getMessage(), 404);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity handleException(UnexpectedTypeException ex) {
        return Result.error(ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception ex) {

        ex.printStackTrace();
        return Result.internalError();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity handleException(AccessDeniedException ex) {
        return Result.error(ex.getMessage(), HttpStatus.UNAUTHORIZED.value());
    }
}
