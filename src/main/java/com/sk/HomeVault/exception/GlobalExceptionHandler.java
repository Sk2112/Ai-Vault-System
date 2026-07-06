package com.sk.HomeVault.exception;

import com.sk.HomeVault.Dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationException(MethodArgumentNotValidException ex){

        System.out.println("Reached Global Exception Handler");
        String errorMessage=ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        ErrorResponseDto errorResponseDto= new ErrorResponseDto();
        errorResponseDto.setMessage(errorMessage);
        errorResponseDto.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponseDto.setTimeStamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
    }
}
