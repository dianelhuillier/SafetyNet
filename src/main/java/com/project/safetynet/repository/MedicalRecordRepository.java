package com.project.safetynet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.safetynet.model.MedicalRecord;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {

	List<MedicalRecord> findByBirthdate(String birthdate);

	MedicalRecord findByFirstName(String firstName);

	MedicalRecord findByLastName(String lastName);

}