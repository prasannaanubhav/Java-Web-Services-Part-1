package com.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinic.model.ClinicalData;

@Repository
public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer>{

}
