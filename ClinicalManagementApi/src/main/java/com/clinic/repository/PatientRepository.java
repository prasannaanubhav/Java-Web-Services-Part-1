package com.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

	public Patient findByFirstname(String name);
}
