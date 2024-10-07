package com.harsh.traini8.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TrainingCenterDTO {
    private Integer id;

    @NotEmpty(message = "Center Name should not be empty")
    @Size(max = 40, message = "Center Name should be less than 40 character")
    private String centerName;

    @NotEmpty(message = "Center Code should not be empty")
    @Size(min = 12, max = 12, message = "Center Code should be of 12 character")
    private String centerCode;

    @NotEmpty(message = "Student Capacity should not be empty")
    private String studentCapacity;

    @NotEmpty(message = "Courses should not be empty")
    private Set<String> courseOffered;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Enter the valid email address")
    private String contactEmail;

    @NotEmpty(message = "Phone no. should not be empty")
    @Size(min = 10, max = 10, message = "Enter the valid phone no.")
    private String contactPhone;

    private String createdOn = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

    @Embedded
    private Address address;
}
