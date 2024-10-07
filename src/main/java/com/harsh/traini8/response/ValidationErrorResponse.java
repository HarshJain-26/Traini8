package com.harsh.traini8.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationErrorResponse {
    private String message;
    private List<String> messages;
    private String status;
    private Integer statusCode;
}
