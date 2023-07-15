package com.c2s.dsif.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.c2s.dsif.entities.TrainingSessionDetails;
import com.c2s.dsif.entities.TrainingSessionDetailsId;
import com.c2s.dsif.entities.dto.SessionDetailsForFrontDTO;
import com.c2s.dsif.service.TrainingSessionDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrainingSessionDetailsController {
	@Autowired
	private TrainingSessionDetailsService trainingSessionDetailsService;

	@GetMapping("/userTotrainingSession")
	public Long doAssignUserToTrainingSession(@RequestParam("userId") Long userId,
			@RequestParam("trainingId") Long trainingId) {
		return trainingSessionDetailsService.doAssignUserToTrainingSession(userId, trainingId);
	}

	@GetMapping("/trainingToTrainingSession")
	public Long doAssignTrainingToTrainingSession(@RequestParam("trainingId") Long trainingId,
			@RequestParam("name") String name) {
		return trainingSessionDetailsService.doAssignTrainingToTrainingSession(trainingId, name);
	}



	@GetMapping("/getAlltrainingSessionDetails")
	private List<SessionDetailsForFrontDTO> getAllTrainingSessionDetails() {
		return trainingSessionDetailsService.getAllTrainingSessionDetails();
	}

	@GetMapping("/getSessionDetailstByIduser")
	private List<SessionDetailsForFrontDTO> getDetailuser(@RequestParam("idUser") Long userId) {
		
		return trainingSessionDetailsService.getTrainingSessionDetailstByIduser(userId);
	}
	
	
	@GetMapping("/getNumberSessionByuser")
	private List<Long> getNumberSessionByuser(@RequestParam("idUser") Long userId) {
		
		return trainingSessionDetailsService.NumberSessionUser(userId);
	}
	
	
	
	
	@GetMapping("/getAllSessionDetailstById")
	public SessionDetailsForFrontDTO getSessionDetailstById(@RequestParam("idUser") Long userId, 
			@RequestParam("idTrainingsession") Long idTrainingsession) {
		TrainingSessionDetailsId id =new TrainingSessionDetailsId(userId,idTrainingsession);
		return trainingSessionDetailsService.getTrainingSessionDetailstById(id);
	}
	
	
	
	
	
	
	
	@DeleteMapping("/deleteTrainingSessionDetails/{trainingSessionDetailsid}")
	private void deletetrainingSessionDetails(
			@PathVariable("trainingSessionDetailsid") TrainingSessionDetailsId trainingSessionDetailsid) {
		trainingSessionDetailsService.delete(trainingSessionDetailsid);
	}
	
	@PostMapping("/saveTrainingSessionDetails")
	private TrainingSessionDetailsId saveTrainingSessionDetails(
			@RequestBody TrainingSessionDetails trainingSessionDetails) {
		trainingSessionDetailsService.saveOrUpdate(trainingSessionDetails);
		return trainingSessionDetails.getTrainingSessionDetailsId();
	}
	
	@PutMapping("/updateTrainingSessionDetails")
	private TrainingSessionDetails updatetrainingSessionDetails(
			@RequestBody TrainingSessionDetails trainingSessionDetails) {
		trainingSessionDetailsService.saveOrUpdate(trainingSessionDetails);
		return trainingSessionDetails;
	}
	
	
	
	@GetMapping("/getAllTrainingSessionDetailsByUsers/{id}")
	private List<TrainingSessionDetails> getAllTrainingSessionDetailsByUser(@PathVariable("id") Long id) {
		return trainingSessionDetailsService.getAllTrainingSessionDetailsByUser(id);
	}
	
	
	
	@GetMapping("/changeStatus")
	public void changeStatus(@RequestParam("idUser") Long userId, 
			@RequestParam("idTrainingsession") Long idTrainingsession,
			@RequestParam("status") String status) {
		TrainingSessionDetailsId id =new TrainingSessionDetailsId(userId,idTrainingsession);
		trainingSessionDetailsService.changeStatus(id, status);
	}

}
