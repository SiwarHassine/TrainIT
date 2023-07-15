package com.c2s.dsif.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.c2s.dsif.entities.TrainingSessionDetails;
import com.c2s.dsif.entities.TrainingSessionDetailsId;
import com.c2s.dsif.entities.User;

public interface TrainingSessionDetailsRepository
		extends JpaRepository<TrainingSessionDetails, TrainingSessionDetailsId> {

	@Query("SELECT t FROM TrainingSessionDetails t where t.user=:user")
	public TrainingSessionDetails getTrainingSessionDetailsByUser(@Param("user") User user);
	
	
	@Query("SELECT t FROM TrainingSessionDetails t where t.user=:user")
	public List<TrainingSessionDetails> getTrainigSessionDetailsByUser(@Param("user") User user);
	
}
