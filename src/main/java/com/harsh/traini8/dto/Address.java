package com.harsh.traini8.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Embeddable
@Data
public class Address {
    @NotEmpty(message = "Address should not be empty")
    private String detailAddress;

    @NotEmpty(message = "State should not be empty")
    private String state;

    @NotEmpty(message = "City should not be empty")
    private String city;

    @NotEmpty(message = "PinCode should not be empty")
    @Size(min = 6, max = 6, message = "Invalid PinCode")
    @Column(length = 6)
    private String pinCode;
}