package com.harsh.traini8.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private String status;
    private Integer statusCode;
}
