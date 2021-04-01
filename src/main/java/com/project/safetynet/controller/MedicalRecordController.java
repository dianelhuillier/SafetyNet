package com.project.safetynet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalRecordController {

	@Autowired
	private MedicalRecordController medicalRecordController;

	@GetMapping
	public MedicalRecordController getMedicalRecordController() {
		return medicalRecordController;
	}

}
