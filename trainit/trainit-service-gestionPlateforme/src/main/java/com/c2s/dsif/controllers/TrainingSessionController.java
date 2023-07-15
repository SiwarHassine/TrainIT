package com.c2s.dsif.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.c2s.dsif.entities.TrainingSession;
import com.c2s.dsif.service.TrainingSessionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrainingSessionController {
	@Autowired
	private TrainingSessionService trainingSessionService;

	@GetMapping("/getAlltrainingSessions")
	private List<TrainingSession> getAllTrainings() {
		return trainingSessionService.getAllTrainingSessions();
	}

	@GetMapping("/getTrainingSession/{traininSessiongid}")
	private TrainingSession getTrainingSession(@PathVariable("traininSessiongid") Long traininSessiongid) {
		return trainingSessionService.getTrainingSessionById(traininSessiongid);
	}

	@DeleteMapping("/deleteTrainingSession/{traininSessiongid}")
	private void deleteTrainingSession(@PathVariable("traininSessiongid") Long traininSessiongid) {
		trainingSessionService.delete(traininSessiongid);
	}

	@PostMapping("/saveTrainingSession")
	private Long saveTrainingSession(@RequestBody TrainingSession trainingSession) {
		trainingSessionService.saveOrUpdate(trainingSession);
		return trainingSession.getId();
	}

	@PutMapping("/updateTrainingSession")
	private TrainingSession updateTrainingSession(@RequestBody TrainingSession trainingSession) {
		trainingSessionService.saveOrUpdate(trainingSession);
		return trainingSession;
	}

}
