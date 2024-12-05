package com.dev.efficiency.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private String status;
    private String message;
    private Object data;
}
