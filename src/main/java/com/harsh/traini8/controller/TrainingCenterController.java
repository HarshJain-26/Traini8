package com.harsh.traini8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.traini8.dto.TrainingCenterDTO;
import com.harsh.traini8.service.TrainingCenterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping("center")
    public ResponseEntity<TrainingCenterDTO> createTrainingCenter(
            @Valid @RequestBody TrainingCenterDTO trainingCenterDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(trainingCenterService.createTrainingCenter(trainingCenterDTO));
    }

    @GetMapping("centers")
    public ResponseEntity<List<TrainingCenterDTO>> fetchAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(trainingCenterService.findAllTrainingCenter());
    }

}
