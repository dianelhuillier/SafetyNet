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

import com.project.safetynet.model.Firestation;
import com.project.safetynet.service.FirestationService;

@RestController
public class FirestationController {

	@Autowired
	private FirestationService firestationService;

	@GetMapping("/firestations")
	public Iterable<Firestation> getFirestations() {
		return firestationService.getFirestations();
	}

	@GetMapping("/firestation/{id}")
	public Firestation getFirestation(@PathVariable("id") final Long id) {
		Optional<Firestation> firestation = firestationService.getFirestationById(id);
		if (firestation.isPresent()) {
			return firestation.get();
		} else {
			return null;
		}
	}

	@PostMapping("/firestation")
	public Firestation createFirestation(@RequestBody Firestation firestation) {
		return firestationService.saveFirestation(firestation);
	}

	@PutMapping("/firestation/{id}")
	public Firestation updateFirestation(@PathVariable("id") final Long id, @RequestBody Firestation firestation) {
		Optional<Firestation> e = firestationService.getFirestationById(id);
		if (e.isPresent()) {
			Firestation currentFirestation = e.get();

			String address = firestation.getAddress();
			if (address != null) {
				currentFirestation.setAddress(address);
			}
			String station = firestation.getStation();
			if (station != null) {
				currentFirestation.setStation(station);
				;
			}
			firestationService.saveFirestation(currentFirestation);
			return currentFirestation;
		} else {
			return null;
		}
	}

	@DeleteMapping("/firestation/{id}")
	public void deleteFirestation(@PathVariable("id") final Long id) {
		firestationService.deleteFirestationById(id);
	}

}