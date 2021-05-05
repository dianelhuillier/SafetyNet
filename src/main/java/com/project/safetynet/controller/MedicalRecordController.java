package com.project.safetynet.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.safetynet.model.MedicalRecord;
import com.project.safetynet.repository.MedicalRecordRepository;
import com.project.safetynet.service.MedicalRecordService;

@RestController
public class MedicalRecordController {

	@Autowired
	private MedicalRecordService medicalRecordService;
	@Autowired
	private MedicalRecordRepository repository;

	@GetMapping("/medicalRecords")
	public Iterable<MedicalRecord> getMedicalRecord() {
		return medicalRecordService.getMedicalRecord();
	}

	@PostMapping("/medicalRecords")
	public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return medicalRecordService.saveMedicalRecord(medicalRecord);
	}

	@PutMapping("/medicalRecords/{id}")
	public MedicalRecord updateMedicalRecord(@PathVariable("id") final Long id,
			@RequestBody MedicalRecord medicalRecord) {
		Optional<MedicalRecord> e = medicalRecordService.getMedicalRecordById(id);
		if (e.isPresent()) {
			MedicalRecord currentMedicalRecord = e.get();

			String firstName = medicalRecord.getFirstName();
			if (firstName != null) {
				currentMedicalRecord.setFirstName(firstName);
			}
			String lastName = medicalRecord.getLastName();
			if (lastName != null) {
				currentMedicalRecord.setLastName(lastName);
				;
			}
			String birtdate = medicalRecord.getBirthdate();
			if (birtdate != null) {
				currentMedicalRecord.setBirthdate(birtdate);
			}
			String medications = medicalRecord.getMedications();
			if (medications != null) {
				currentMedicalRecord.setMedications(medications);
				;
			}
			String allergies = medicalRecord.getAllergies();
			if (allergies != null) {
				currentMedicalRecord.setAllergies(allergies);
				;
			}
			medicalRecordService.saveMedicalRecord(currentMedicalRecord);
			return currentMedicalRecord;
		} else {
			return null;
		}
	}

	/*
	 * @DeleteMapping("/medicalRecords/firstName=<firstName>&lastName=<lastName>")
	 * void deleteMedicalRecord(@PathVariable String firstName, @PathVariable String
	 * lastName) { repository.deleteByFirstNameAndLastName(firstName, lastName); }
	 */
	@DeleteMapping("/medicalRecords/{id}")
	public void deleteMedicalRecord(@PathVariable("id") final Long id) {
		medicalRecordService.deleteMedicalRecordById(id);
	}

}