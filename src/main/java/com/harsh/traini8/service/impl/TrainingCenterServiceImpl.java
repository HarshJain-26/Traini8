package com.harsh.traini8.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsh.traini8.dto.TrainingCenterDTO;
import com.harsh.traini8.entity.TrainingCenter;
import com.harsh.traini8.repository.TrainingCenterRepository;
import com.harsh.traini8.service.TrainingCenterService;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TrainingCenterDTO createTrainingCenter(TrainingCenterDTO trainingCenterDTO) {
        // convert DTO - Entity-Model
        TrainingCenter trainingCenterModel = modelMapper.map(trainingCenterDTO, TrainingCenter.class);

        System.out.println("trainingCenterModel: " + trainingCenterModel);

        // save the data into the database
        TrainingCenter trainingCenter = trainingCenterRepository.save(trainingCenterModel);

        // convert Entity-Model - DTO
        return modelMapper.map(trainingCenter, TrainingCenterDTO.class);
    }

    @Override
    public List<TrainingCenterDTO> findAllTrainingCenter() {
        // returns Entity-Model
        List<TrainingCenter> trainingCenters = trainingCenterRepository.findAll();

        // convert Entity-Model - DTO
        return trainingCenters.stream()
                .map(trainingCenter -> modelMapper.map(trainingCenter, TrainingCenterDTO.class))
                .toList();
    }

}
