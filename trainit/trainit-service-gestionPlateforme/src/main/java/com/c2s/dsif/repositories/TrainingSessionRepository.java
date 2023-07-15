package com.c2s.dsif.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c2s.dsif.entities.TrainingSession;

public interface TrainingSessionRepository extends JpaRepository<TrainingSession, Long> {

}
