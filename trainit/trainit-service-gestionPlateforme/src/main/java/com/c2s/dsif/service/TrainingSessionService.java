package com.c2s.dsif.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2s.dsif.entities.TrainingSession;
import com.c2s.dsif.repositories.TrainingRepository;
import com.c2s.dsif.repositories.TrainingSessionRepository;

@Service
public class TrainingSessionService {
	@Autowired
	TrainingSessionRepository trainingSessionRepository;
	@Autowired
	TrainingRepository trainingRepository;

	public List<TrainingSession> getAllTrainingSessions() {
		List<TrainingSession> TrainingSessions = new ArrayList<TrainingSession>();
		trainingSessionRepository.findAll().forEach(trainingSession -> TrainingSessions.add(trainingSession));
		return TrainingSessions;
	}

	public TrainingSession getTrainingSessionById(Long id) {
		return trainingSessionRepository.findById(id).get();
	}

	public void saveOrUpdate(TrainingSession trainingSession) {
		trainingSessionRepository.save(trainingSession);
	}

	public void delete(Long id) {
		trainingSessionRepository.deleteById(id);
	}

}
