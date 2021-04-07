package com.project.safetynet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.safetynet.model.Firestation;
import com.project.safetynet.model.Person;
import com.project.safetynet.service.FirestationService;
import com.project.safetynet.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	@Autowired
	private FirestationService firestationService;

	/**
	 * Read - Get all employees
	 * 
	 * @return - An Iterable object of Employee full filled
	 */
	@GetMapping("/person")
	public Iterable<Person> getPersons() {
		return personService.getPersons();
	}

	@GetMapping("/firestation")
	public List<Person> getPersonsByFirestationNumber(@RequestParam(value = "stationNumber") String station) {
		List<Firestation> firestations = firestationService.getFirestationByStation(station);

//		HashMap<Person, String> ageList = new HashMap<Person, String>();

		List<Person> persons = new ArrayList<>();
		for (Firestation firestation : firestations) {
			persons.addAll(personService.getPersonsByAddress(firestation.getAddress()));

		}

		return persons;
	}

//	@GetMapping("/phoneByStation")
//	public List<Person> getPhoneByFirestationNumber(@RequestParam(value = "phoneAlert") String station) {
//		// List<Firestation> firestations = firestationService.getFirestationByStation(station);
//
//		List<Person> persons = new ArrayList<>();
//
//		for (Person person : persons) {
//			persons.addAll(personService.getPhoneByStation(person.getPhone()));
//
//		}
//		return persons;
//
//	}
	@GetMapping("/communityEmail")
	public Iterable<Person> getPersons(@RequestParam(value = "city") String city) { // lien bon, liste vide
		return personService.getPersons();

	}
}