package com.harsh.traini8.exception;

import java.util.List;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.harsh.traini8.response.ErrorResponse;
import com.harsh.traini8.response.ValidationErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

        // will handle MethodArgumentNotValidException
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ValidationErrorResponse> handleMethodArgumentNotValidException(
                        MethodArgumentNotValidException e) {

                HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

                List<String> errorMessages = e.getFieldErrors().stream()
                                .map(fieldError -> fieldError.getDefaultMessage())
                                .toList();

                ValidationErrorResponse validationErrorResponse = ValidationErrorResponse.builder()
                                .message("Validation Error")
                                .messages(errorMessages)
                                .status(httpStatus.name())
                                .statusCode(httpStatus.value())
                                .build();

                return ResponseEntity.status(httpStatus).body(validationErrorResponse);
        }

        // will handle NoResourceFoundException
        @ExceptionHandler(NoResourceFoundException.class)
        public ResponseEntity<ErrorResponse> handleNoResourceFoundException(NoResourceFoundException e) {

                HttpStatus httpStatus = HttpStatus.NOT_FOUND;

                ErrorResponse errorResponse = ErrorResponse.builder()
                                .message(e.getMessage())
                                .status(httpStatus.name())
                                .statusCode(httpStatus.value())
                                .build();

                return ResponseEntity.status(httpStatus).body(errorResponse);
        }

        // will handle NoResourceFoundException
        @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
        public ResponseEntity<ErrorResponse> handleNoResourceFoundException(InvalidDataAccessResourceUsageException e) {

                HttpStatus httpStatus = HttpStatus.NOT_FOUND;

                ErrorResponse errorResponse = ErrorResponse.builder()
                                .message(e.getMessage())
                                .status(httpStatus.name())
                                .statusCode(httpStatus.value())
                                .build();

                return ResponseEntity.status(httpStatus).body(errorResponse);
        }

        //  will handle other default exceptions
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handleException(Exception e) {

                HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

                ErrorResponse errorResponse = ErrorResponse.builder()
                                .message(e.getMessage())
                                .status(httpStatus.name())
                                .statusCode(httpStatus.value())
                                .build();

                return ResponseEntity.status(httpStatus).body(errorResponse);
        }

}
