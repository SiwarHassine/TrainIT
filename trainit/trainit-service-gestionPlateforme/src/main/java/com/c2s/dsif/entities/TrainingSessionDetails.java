package com.c2s.dsif.entities;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TrainingSessionDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5217980024081196460L;
	
	@EmbeddedId
	private TrainingSessionDetailsId trainingSessionDetailsId;
	private Date dateOfSession;
	private String status;
	private boolean request;
	private String feedback;
	private String question;
	private String answer;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", updatable = false, insertable = false)
	private User user;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idTrainingsession", referencedColumnName = "id", updatable = false, insertable = false)
	private TrainingSession trainingSession;

	public TrainingSessionDetails() {
	
	}
	public TrainingSessionDetails(Date dateOfSession, String status, boolean request, User user, TrainingSession trainingSession) {
		super();
		this.trainingSessionDetailsId = new TrainingSessionDetailsId(user.getId(), trainingSession.getId());
		this.dateOfSession = dateOfSession;
		this.status = status;
		this.request = request;
		this.user = user;
		this.trainingSession = trainingSession;
	}

	public Date getDateOfSession() {
		return dateOfSession;
	}

	public void setDateOfSession(Date dateOfSession) {
		this.dateOfSession = dateOfSession;
	}

	public TrainingSessionDetailsId getTrainingSessionDetailsId() {
		return trainingSessionDetailsId;
	}

	public void setTrainingSessionDetailsId(TrainingSessionDetailsId trainingSessionDetailsId) {
		this.trainingSessionDetailsId = trainingSessionDetailsId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isRequest() {
		return request;
	}

	public void setRequest(boolean request) {
		this.request = request;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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
