package com.project.safetynet.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
//http://localhost:8080/communityEmail?city=Culver

	@GetMapping("/communityEmail")
	public List<String> getPersonsEmail(@RequestParam(value = "city") String city) { // value city = value culver ? osef
		List<Person> persons = personService.getPersonsByCity(city);
		List<String> listEmails = persons.stream().map(Person::getEmail).collect(Collectors.toList());
		return listEmails;

	}
	// http://localhost:8080/allEmails?city=Culver

	@GetMapping("/allEmails")
	public List<String> getEmails(@RequestParam(value = "city") String city) {
		Iterable<Person> persons = personService.getPersons();
		List<String> listEmails = ((Collection<Person>) persons).stream().map(Person::getEmail)
				.collect(Collectors.toList());

		return listEmails;

	}

	// TODO : Cette url doit retourner la liste des habitants vivant à l’adresse
	// donnée ainsi que le numéro de la caserne
	// de pompiers la desservant. La liste doit inclure le nom, le numéro de
	// téléphone, l'âge et les antécédents
	// médicaux (médicaments, posologie et allergies) de chaque personne.

	// http://localhost:8080/fire?address=%3Caddress

	@GetMapping("/fire")
	public List<Person> getInfoByAddress(@RequestParam(value = "address") String address) {
		List<Person> persons = personService.getPersonsByAddress(address); // ok il faut mapper le nom et le medrecord

		for (Person person : persons) {

		}
		// List<String> medicalRecords =
		// MedicalRecordService.getMedicalByFirstName(personService.getPersonByFirstName(firstName));

		return persons;

	}

}