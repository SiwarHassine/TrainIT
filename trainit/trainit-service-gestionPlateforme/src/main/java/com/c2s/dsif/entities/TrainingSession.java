package com.c2s.dsif.entities;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_TRAININGSESSION")
public class TrainingSession implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	
	@ManyToOne
	@Cascade(CascadeType.PERSIST)
	private Training training;
	
	@JsonIgnore
	@OneToMany(mappedBy = "trainingSession")
	private List<TrainingSessionDetails> trainingSessionDetails;

	public TrainingSession() {
	}

	public TrainingSession(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TrainingSessionDetails> getTrainingSessionDetails() {
		return trainingSessionDetails;
	}

	public void setTrainingSessionDetails(List<TrainingSessionDetails> trainingSessionDetails) {
		this.trainingSessionDetails = trainingSessionDetails;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

}
