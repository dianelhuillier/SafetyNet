package com.project.safetynet.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class Data { // onetomany => data

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Person> persons = null;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Firestation> firestations = null;

	@OneToMany(fetch = FetchType.LAZY)
	private List<MedicalRecord> medicalrecords = null;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
}