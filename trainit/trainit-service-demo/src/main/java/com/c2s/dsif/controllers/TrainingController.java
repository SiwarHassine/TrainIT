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

import com.c2s.dsif.entities.Training;
import com.c2s.dsif.service.TrainingService;

@RestController
@CrossOrigin(origins = "*")
public class TrainingController {
	@Autowired
	private TrainingService trainingService;

	@GetMapping("/getAlltraining")
	private List<Training> getAllTrainings() {
		return trainingService.getAllTrainings();
	}

	@GetMapping("/getTraining/{trainingid}")
	private Training getUser(@PathVariable("trainingid") Long trainingid) {
		return trainingService.getUserById(trainingid);
	}

	@DeleteMapping("/deleteTraining/{trainingid}")
	private void deleteTraining(@PathVariable("trainingid") Long trainingid) {
		trainingService.delete(trainingid);
	}

	@PostMapping("/saveTraining")
	private Long saveTraining(@RequestBody Training training) {
		trainingService.saveOrUpdate(training);
		return training.getId();
	}

	@PutMapping("/updateTraining")
	private Training updateTraining(@RequestBody Training training) {
		trainingService.saveOrUpdate(training);
		return training;
	}

}
