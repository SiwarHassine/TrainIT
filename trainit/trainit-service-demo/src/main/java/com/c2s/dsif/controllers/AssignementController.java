package com.c2s.dsif.controllers;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c2s.dsif.entities.Assignment;
import com.c2s.dsif.entities.Training;
import com.c2s.dsif.entities.TrainingSession;
import com.c2s.dsif.entities.User;
import com.c2s.dsif.repositories.AssignmentRepository;
import com.c2s.dsif.repositories.TrainingSessionRepository;
import com.c2s.dsif.repositories.UserRepository;

@RestController
public class AssignementController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TrainingSessionRepository trainingSessionRepository;
	@Autowired
	private AssignmentRepository assignmentRepository;

	@GetMapping("/demo")
	public String doAssignUserToTrainingSession() {
		Optional<User> userToAssign = userRepository.findById(1L);
		Optional<TrainingSession> trainingSessionToaAtend = trainingSessionRepository.findById(1L);

		Assignment assignment = new Assignment(new Date(), userToAssign.get(), trainingSessionToaAtend.get());

		assignmentRepository.save(assignment);

		return "ok";
	}

	@GetMapping("/training")
	public String doAssignTrainingToTrainingSession() {

		Training training = new Training("Docker");

		TrainingSession trainingSession = new TrainingSession("mahboula");
		trainingSession.setTraining(training);

		trainingSessionRepository.save(trainingSession);

		return "ok";
	}

}
