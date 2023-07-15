package com.c2s.dsif.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2s.dsif.entities.AssignementId;
import com.c2s.dsif.entities.Assignment;
import com.c2s.dsif.entities.Training;
import com.c2s.dsif.entities.TrainingSession;
import com.c2s.dsif.entities.User;
import com.c2s.dsif.repositories.AssignmentRepository;
import com.c2s.dsif.repositories.TrainingSessionRepository;
import com.c2s.dsif.repositories.UserRepository;

@Service

public class AssignementService {
	@Autowired
	AssignmentRepository assignmentrepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TrainingSessionRepository trainingSessionRepository;
	@Autowired
	private AssignmentRepository assignmentRepository;

	public String doAssignUserToTrainingSession(Long userId, Long trainingId) {
		Optional<User> userToAssign = userRepository.findById(userId);
		Optional<TrainingSession> trainingSessionToaAtend = trainingSessionRepository.findById(trainingId);

		if (userToAssign.isPresent() && trainingSessionToaAtend.isPresent()) {
		    Assignment assignment = new Assignment(new Date(), userToAssign.get(), trainingSessionToaAtend.get());
		    assignmentRepository.save(assignment);
		    return "ok";
		} else {
		    return "User or Training Session not found.";
		}
	}

	public String doAssignTrainingToTrainingSession() {

		Training training = new Training("Docker");

		TrainingSession trainingSession = new TrainingSession("mahboula");
		trainingSession.setTraining(training);

		trainingSessionRepository.save(trainingSession);

		return "ok";
	}

	public List<Assignment> getAllAssignment() {
		List<Assignment> assignments = new ArrayList<Assignment>();
		assignmentrepository.findAll().forEach(assignment -> assignments.add(assignment));
		return assignments;
	}

	public Optional<Assignment> getAssignmentById(AssignementId id) {
		return assignmentrepository.findById(id);
	}

	public void saveOrUpdate(Assignment assignment) {
		assignmentrepository.save(assignment);
	}

	public void delete(AssignementId id) {
		assignmentrepository.deleteById(id);
	}

}
