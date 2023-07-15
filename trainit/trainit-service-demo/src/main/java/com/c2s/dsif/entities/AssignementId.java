package com.c2s.dsif.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class AssignementId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idUser;
	private Long idTrainingsession;

	public AssignementId() {
	}

	public AssignementId(Long idUser, Long idTrainingsession) {
		super();
		this.setIdUser(idUser);
		this.setIdTrainingsession(idTrainingsession);
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(idTrainingsession, idUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignementId other = (AssignementId) obj;
		return Objects.equals(idTrainingsession, other.idTrainingsession) && Objects.equals(idUser, other.idUser);
	}

}
