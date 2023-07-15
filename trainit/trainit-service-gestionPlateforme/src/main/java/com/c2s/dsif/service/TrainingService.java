package com.c2s.dsif.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2s.dsif.entities.Training;
import com.c2s.dsif.repositories.TrainingRepository;

@Service
public class TrainingService {
	@Autowired 
	TrainingRepository trainingRepository;
	
	
	
	public List<Training> getAllTrainings()   
	{  
		List<Training> Trainings = new ArrayList<Training>();  
		trainingRepository.findAll().forEach(Training1 -> Trainings.add(Training1));  
		return Trainings;  	
	}

	public Training getTrainingById(Long id) {
		return trainingRepository.findById(id).get();
	}

	public void saveOrUpdate(Training training) {
		trainingRepository.save(training);
	}

	public void delete(Long id) {
		trainingRepository.deleteById(id);
	}
	
	
}
