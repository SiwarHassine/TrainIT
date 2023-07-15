package com.c2s.dsif.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2s.dsif.entities.Training;
import com.c2s.dsif.entities.TrainingSession;
import com.c2s.dsif.entities.TrainingSessionDetails;
import com.c2s.dsif.entities.TrainingSessionDetailsId;
import com.c2s.dsif.entities.User;
import com.c2s.dsif.entities.dto.SessionDetailsForFrontDTO;
import com.c2s.dsif.repositories.TrainingRepository;
import com.c2s.dsif.repositories.TrainingSessionDetailsRepository;
import com.c2s.dsif.repositories.TrainingSessionRepository;
import com.c2s.dsif.repositories.UserRepository;

@Service

public class TrainingSessionDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TrainingSessionRepository trainingSessionRepository;
	@Autowired
	private TrainingSessionDetailsRepository trainingSessionDetailsRepository;
	@Autowired
	private TrainingRepository trainingRepository;
	
	
// assign user to training session 
	public Long doAssignUserToTrainingSession(Long userId, Long trainingId) {
		Optional<User> userToAssign = userRepository.findById(userId);
		Optional<TrainingSession> trainingSessionToAttend = trainingSessionRepository.findById(trainingId);

		if (userToAssign.isPresent() && trainingSessionToAttend.isPresent()) {
			TrainingSessionDetails trainingSessionDetails = new TrainingSessionDetails(new Date(), "Waiting", false,
					userToAssign.get(), trainingSessionToAttend.get());
			trainingSessionDetailsRepository.save(trainingSessionDetails);
			return 1L;
		} else {
			return -1L;
		}
	}

	
	// open training session from a existing session 
	
	public Long doAssignTrainingToTrainingSession(Long trainingId, String name) {

		Optional<Training> trainingOptional = trainingRepository.findById(trainingId);
		if (trainingOptional.isPresent()) {
		    TrainingSession trainingSession = new TrainingSession(name);
		    Training training = trainingOptional.get(); 
		    trainingSession.setTraining(training);
		    trainingSessionRepository.save(trainingSession);
		    return 1L;
		} else {
		    return -1L;
		}
	}

	
	// list of details to all the training session 
	
	public List<SessionDetailsForFrontDTO> getAllTrainingSessionDetails(){
		List<SessionDetailsForFrontDTO> dto=new ArrayList<SessionDetailsForFrontDTO>();
		List<TrainingSessionDetails> tsd=trainingSessionDetailsRepository.findAll();
		for(TrainingSessionDetails e: tsd) {
			SessionDetailsForFrontDTO d=new SessionDetailsForFrontDTO();
			d.setIdUser(e.getUser().getId());
			d.setIdTrainingsession((e.getTrainingSession().getId()));
			d.setDateOfSession(e.getDateOfSession());
			d.setStatus(e.getStatus());
			d.setNameUser(e.getUser().getName());
			d.setNameSession(e.getTrainingSession().getName());
			
			dto.add(d);
			
		}
		
		return dto;
	}

	
	// list of details session by user  
	public List<SessionDetailsForFrontDTO> getTrainingSessionDetailstByIduser(Long userId) {
		User u =userRepository.getById(userId);
		List<SessionDetailsForFrontDTO> dto=new ArrayList<SessionDetailsForFrontDTO>();
		List<TrainingSessionDetails> tsd=trainingSessionDetailsRepository.getTrainigSessionDetailsByUser(u);
		for(TrainingSessionDetails e: tsd) {
			SessionDetailsForFrontDTO d=new SessionDetailsForFrontDTO();
			d.setIdUser(e.getUser().getId());
			d.setIdTrainingsession((e.getTrainingSession().getId()));
			d.setDateOfSession(e.getDateOfSession());
			d.setStatus(e.getStatus());
			d.setNameUser(e.getUser().getName());
			d.setNameSession(e.getTrainingSession().getName());
			
			dto.add(d);
			
		}
		return dto;
		
	}

	
	// list of Number Session by User 
		public List<Long> NumberSessionUser(Long userId) {
			
			Long numDone=0L,numWaiting=0L,numProgress=0L,numS=0L;
			User u =userRepository.getById(userId);
			List<Long> d=new ArrayList<Long>();
			List<TrainingSessionDetails> tsd=trainingSessionDetailsRepository.getTrainigSessionDetailsByUser(u);
			for(TrainingSessionDetails e: tsd) {
				
				switch(e.getStatus()) {
				case "Waiting":numWaiting+=1;break;
				case "Done": numDone+=1;break;
				case "In Progress": numProgress+=1;break;
				}
				
			}
			d.add(numWaiting+numProgress+numDone);
			d.add(numWaiting);
			d.add(numProgress);
			d.add(numDone);
			return d;
			
		}
	
	
	
// list of details session by iduser and id session 
	
	public SessionDetailsForFrontDTO getTrainingSessionDetailstById(TrainingSessionDetailsId id) {
		
		TrainingSessionDetails session = trainingSessionDetailsRepository.getById(id);

			SessionDetailsForFrontDTO d=new SessionDetailsForFrontDTO();
			d.setIdUser(session.getUser().getId());
			d.setIdTrainingsession((session.getTrainingSession().getId()));
			d.setDateOfSession(session.getDateOfSession());
			d.setStatus(session.getStatus());
			d.setNameUser(session.getUser().getName());
			d.setNameSession(session.getTrainingSession().getName());
			
	
		
		return d;
		
	}

	

	public void saveOrUpdate(TrainingSessionDetails trainingSessionDetails) {
		trainingSessionDetailsRepository.save(trainingSessionDetails);
	}

	public void delete(TrainingSessionDetailsId id) {
		trainingSessionDetailsRepository.deleteById(id);
	}

	public List<TrainingSessionDetails> getAllTrainingSessionDetailsByUser(Long id) {
		List<TrainingSessionDetails> trainingSessionDetails = new ArrayList<TrainingSessionDetails>();
		final User u = userRepository.findById(id).orElse(null);
		trainingSessionDetailsRepository.findAll().forEach(trainingSessionDetail1 -> {
			if (trainingSessionDetail1.getUser() == u) {
				trainingSessionDetails.add(trainingSessionDetail1);
			}
		});
		return trainingSessionDetails;
	}
	
	
	
		
	
	
	public void changeStatus(TrainingSessionDetailsId id ,String status) {
		
		TrainingSessionDetails session = trainingSessionDetailsRepository.getById(id);
		session.setStatus(status);
		trainingSessionDetailsRepository.save(session);
		
	}

}
