package com.c2s.dsif.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_USER")

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Name;
	private String Password;
	private String dateNaiss;
	private String NameManager;
	
	private String userRoles;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<TrainingSessionDetails> trainingSessionDetails;

	public User() {
	}

	public User(String name, String password, String userRoles,String date,String manager) {
		super();
		Name = name;
		Password = password;
		this.userRoles = userRoles;
		this.dateNaiss=date;
		this.NameManager=manager;
	}

	public String getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(String dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public List<TrainingSessionDetails> getTrainingSessionDetails() {
		return trainingSessionDetails;
	}

	public void setAssignments(List<TrainingSessionDetails> trainingSessionDetails) {
		this.trainingSessionDetails = trainingSessionDetails;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(String userRoles) {
		this.userRoles = userRoles;
	}

	public void setTrainingSessionDetails(List<TrainingSessionDetails> trainingSessionDetails) {
		this.trainingSessionDetails = trainingSessionDetails;
	}

	public String getNameManager() {
		return NameManager;
	}

	public void setNameManager(String nameManager) {
		NameManager = nameManager;
	}

}
