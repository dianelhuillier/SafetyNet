package com.project.safetynet.service;

import java.util.List;
import java.util.Optional;

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

//	public Collection<? extends Person> getStationNumberByAddress(String address) {
//		return firestationRepository.findByAddress(address);
//	}

	public Firestation findStationNumberByAddress(String address) {
		return firestationRepository.findStationByAddress(address);
	}

	public Iterable<Firestation> getFirestations() {
		return firestationRepository.findAll();
	}

	public Optional<Firestation> getFirestationById(final Long id) {
		return firestationRepository.findById(id);
	}

	public Firestation saveFirestation(Firestation firestation) {
		Firestation savedFirestation = firestationRepository.save(firestation);
		return savedFirestation;
	}

	public void deleteFirestationById(final Long id) {
		firestationRepository.deleteById(id);
	}

}