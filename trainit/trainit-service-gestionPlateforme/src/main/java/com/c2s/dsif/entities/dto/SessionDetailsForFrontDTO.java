package com.c2s.dsif.entities.dto;

import java.util.Date;

public class SessionDetailsForFrontDTO {

	private Long idUser;
	private Long idTrainingsession;
	private String nameUser;
	private String nameSession;
	private Date dateOfSession;
	private String status;
	
	
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Long getIdTrainingsession() {
		return idTrainingsession;
	}
	public void setIdTrainingsession(Long idTrainingsession) {
		this.idTrainingsession = idTrainingsession;
	}
	public Date getDateOfSession() {
		return dateOfSession;
	}
	public void setDateOfSession(Date dateOfSession) {
		this.dateOfSession = dateOfSession;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getNameSession() {
		return nameSession;
	}
	public void setNameSession(String nameSession) {
		this.nameSession = nameSession;
	}

}
