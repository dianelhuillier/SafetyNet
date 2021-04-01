package com.project.safetynet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.safetynet.model.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {

}
