package com.harsh.traini8.service;

import java.util.List;

import com.harsh.traini8.dto.TrainingCenterDTO;

public interface TrainingCenterService {

    TrainingCenterDTO createTrainingCenter(TrainingCenterDTO trainingCenterDTO);

    List<TrainingCenterDTO> findAllTrainingCenter();

}
