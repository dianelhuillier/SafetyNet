package com.project.safetynet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.safetynet.model.MedicalRecord;
import com.project.safetynet.repository.MedicalRecordRepository;

import lombok.Data;

@Service
@Data
public class MedicalRecordService {

	@Autowired
	private MedicalRecordRepository medicalRecordRepository;

	public List<MedicalRecord> getBirthdate(String birthdate) {
		return medicalRecordRepository.findByBirthdate(birthdate);
	}

	public MedicalRecord findMedicalRecordByFirstName(String firstName) {
		return medicalRecordRepository.findByFirstName(firstName);
	}

	public MedicalRecord findMedicalRecordByLastName(String lastName) {
		return medicalRecordRepository.findByLastName(lastName);
	}

	public Iterable<MedicalRecord> getMedicalRecord() {
		return medicalRecordRepository.findAll();
	}

	public MedicalRecord findByFirstNameAndLastName(String firstName, String lastName) {
		return medicalRecordRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
		MedicalRecord savedMedicalRecord = medicalRecordRepository.save(medicalRecord);
		return savedMedicalRecord;
	}

	public Optional<MedicalRecord> getMedicalRecordById(final Long id) {
		return medicalRecordRepository.findById(id);
	}

	public void deleteMedicalRecordById(Long id) {
		medicalRecordRepository.deleteById(id);

	}

}
