package com.curso.springboot.error.springboot_error.controllers;


import com.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.curso.springboot.error.springboot_error.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByZero(Exception e){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error division por cero!");
        error.setMessage(error.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> rootNotFound(Exception e){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Ruta no encontrada");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(error.getStatus()).body(error);
    }

//    @ExceptionHandler(NumberFormatException.class)
//    public ResponseEntity<Error> formatException(Exception e){
//        Error error = new Error();
//        error.setDate(new Date());
//        error.setError("Parse no valido");
//        error.setMessage(e.getMessage());
//        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//
//        return ResponseEntity.status(error.getStatus()).body(error);
//
//    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception e){
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error","Parse no valido o incorrecto");
        error.put("message", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    @ExceptionHandler({NullPointerException.class,
            HttpMessageNotWritableException.class,
            UserNotFoundException.class})
    public ResponseEntity<Error> userNotFoundException (Exception e){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("El usuario o rol no existe!");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(error.getStatus()).body(error);
    }





}
