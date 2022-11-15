package com.example.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<MyErrorDetails> dataExceptionHandler(DataNotFoundException customerNotFoundException, WebRequest webRequest){

        MyErrorDetails myErrorDetails = new MyErrorDetails();
        myErrorDetails.setLocalDateTime(LocalDateTime.now());
        myErrorDetails.setMessage(customerNotFoundException.getMessage());
        myErrorDetails.setDescription(webRequest.getDescription(false));

        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> otherExceptionsHandler(Exception exception, WebRequest webRequest){

        MyErrorDetails myErrorDetails = new MyErrorDetails();
        myErrorDetails.setLocalDateTime(LocalDateTime.now());
        myErrorDetails.setMessage(exception.getMessage());
        myErrorDetails.setDescription(webRequest.getDescription(false));

        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);
    }

}
