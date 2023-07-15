package com.c2s.dsif.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Assignment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5217980024081196460L;
	@EmbeddedId
	private AssignementId assignementId;
	private Date dateOfSession;

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", updatable = false, insertable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "idTrainingsession", referencedColumnName = "id", updatable = false, insertable = false)
	private TrainingSession trainingSession;

	public Assignment() {
	}

	public Assignment(Date dateOfSession, User user, TrainingSession trainingSession) {
		super();
		this.assignementId = new AssignementId(user.getId(), trainingSession.getId());
		this.dateOfSession = dateOfSession;
		this.user = user;
		this.trainingSession = trainingSession;
	}

	public AssignementId getAssignementId() {
		return assignementId;
	}

	public void setAssignementId(AssignementId assignementId) {
		this.assignementId = assignementId;
	}

	public Date getDateOfSession() {
		return dateOfSession;
	}

	public void setDateOfSession(Date dateOfSession) {
		this.dateOfSession = dateOfSession;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TrainingSession getTrainingSession() {
		return trainingSession;
	}

	public void setTrainingSession(TrainingSession trainingSession) {
		this.trainingSession = trainingSession;
	}

}
