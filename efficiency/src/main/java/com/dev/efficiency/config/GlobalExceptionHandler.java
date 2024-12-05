package com.dev.efficiency.config;

import com.dev.efficiency.dto.ApiResponse;
import com.dev.efficiency.exception.ResourceNotFoundException;
import com.dev.efficiency.exception.SprintNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse>  resourceNotFound(ResourceNotFoundException ex){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("Failure");
        apiResponse.setMessage(ex.getMessage());
        apiResponse.setData(Collections.emptyList());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @ExceptionHandler(SprintNotFoundException.class)
    public ResponseEntity<ApiResponse>  sprintNotFound(SprintNotFoundException ex){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("Failure");
        apiResponse.setMessage(ex.getMessage());
        apiResponse.setData(Collections.emptyList());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ApiResponse>  dataAccessException(DataAccessException ex) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus("Failure");
        apiResponse.setMessage(ex.getMessage());
        apiResponse.setData(Collections.emptyList());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }
}
