package com.c2s.dsif.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c2s.dsif.entities.AssignementId;
import com.c2s.dsif.entities.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, AssignementId> {

}
