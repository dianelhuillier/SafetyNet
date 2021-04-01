package com.project.safetynet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.safetynet.model.Firestation;
import com.project.safetynet.repository.FirestationRepository;

import lombok.Data;
//une couche pour chaque

@Data
@Service

public class FirestationService {

	// PersonService

	@Autowired
	private FirestationRepository firestationRepository;

	public List<Firestation> getFirestationByStation(final String station) {
		return firestationRepository.findByStation(station);
	}

}