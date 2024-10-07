package com.harsh.traini8.entity;

import java.util.Set;

import com.harsh.traini8.dto.Address;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.ToString;

@Entity
@ToString
public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40)
    private String centerName;

    @Column(length = 12)
    private String centerCode;

    private String studentCapacity;

    @ElementCollection
    @CollectionTable(name = "center_course", joinColumns = @JoinColumn(name = "center_id"))
    private Set<String> courseOffered;

    private String contactEmail;

    @Column(length = 10)
    private String contactPhone;

    private String createdOn;
    
    private Address address;
}
