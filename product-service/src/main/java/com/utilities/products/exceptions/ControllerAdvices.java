package com.utilities.products.exceptions;

import com.utilities.products.dtos.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception exception, HttpServletRequest request) {
        ErrorResponseDto error = new ErrorResponseDto(exception, request);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        error.setStatus(status.toString());

        return new ResponseEntity<ErrorResponseDto>(error, status);
    }
}
