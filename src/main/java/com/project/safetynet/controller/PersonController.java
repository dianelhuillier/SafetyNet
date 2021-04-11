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

/**
 * @author tite_
 *
 */
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

	/**
	 * TODO : http://localhost:8080/firestation?stationNumber=%3Cstation_number
	 * Cette url doit retourner une liste des personnes couvertes par la caserne de
	 * pompiers correspondante. Donc, si le numéro de station = 1, elle doit
	 * renvoyer les habitants couverts par la station numéro 1. La liste doit
	 * inclure les informations spécifiques suivantes : prénom, nom, adresse, numéro
	 * de téléphone. De plus, elle doit fournir un décompte du nombre d'adultes et
	 * du nombre d'enfants (tout individu âgé de 18 ans ou moins) dans la zone
	 * desservie. TODO : DECOMPTE
	 */
	@GetMapping("/firestation")
	public List<Person> getPersonsByFirestationNumber(@RequestParam(value = "stationNumber") String station) {
		List<Firestation> firestations = firestationService.getFirestationByStation(station);

//		HashMap<Person, String> ageList = new HashMap<Person, String>();

		List<Person> persons = new ArrayList<>();
		for (Firestation firestation : firestations) {
			persons.addAll(personService.getPersonsByAddress(firestation.getAddress()));
//			Stream<List<Person>> ageList = Stream.of(persons).filter(personService.getPersonByAge()<18); //passer par medrecord pour l'age

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

	/**
	 * http://localhost:8080/communityEmail?city=Culver TODO : Cette url doit
	 * retourner les adresses mail de tous les habitants de la ville
	 */
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

	/*
	 * TODO : Cette url doit retourner la liste des habitants vivant à l’adresse
	 * donnée ainsi que le numéro de la caserne de pompiers la desservant. La liste
	 * doit inclure le nom, le numéro de téléphone, l'âge et les antécédents
	 * médicaux (médicaments, posologie et allergies) de chaque personne.
	 */
	// http://localhost:8080/fire?address=%3Caddress

	@GetMapping("/fire")
	public List<Person> getInfoByAddress(@RequestParam(value = "address") String address) {
		List<Person> persons = personService.getPersonsByAddress(address); // ok il faut mapper le nom et le medrecord

		for (Person person : persons) {
//if string name json 1 = string name json 2 then new list with all
		}
		// List<String> medicalRecords =
		// MedicalRecordService.getMedicalByFirstName(personService.getPersonByFirstName(firstName));

		return persons;

	}

	/*
	 * http://localhost:8080/childAlert?address=<address> TODO : Cette url doit
	 * retourner une liste d'enfants (tout individu âgé de 18 ans ou moins) habitant
	 * à cette adresse. La liste doit comprendre le prénom et le nom de famille de
	 * chaque enfant, son âge et une liste des autres membres du foyer. S'il n'y a
	 * pas d'enfant, cette url peut renvoyer une chaîne vide.
	 */

	/*
	 * TODO : http://localhost:8080/phoneAlert?firestation=<firestation_number>
	 * Cette url doit retourner une liste des numéros de téléphone des résidents
	 * desservis par la caserne de pompiers. Nous l'utiliserons pour envoyer des
	 * messages texte d'urgence à des foyers spécifiques.
	 */

	@GetMapping("/phoneAlert")
	public List<String> getPhoneByStation(@RequestParam(value = "firestation") String station) {
		List<Firestation> firestations = firestationService.getFirestationByStation(station);
		List<Person> persons = new ArrayList<>();
		for (Firestation firestation : firestations) {
			persons.addAll(personService.getPersonsByAddress(firestation.getAddress()));
		}
		List<String> listPhoneByStation = ((Collection<Person>) persons).stream().map(Person::getPhone)
				.collect(Collectors.toList());

		return listPhoneByStation;
	}

}
/*
 * TODO : http://localhost:8080/flood/stations?stations=<a list of
 * station_numbers> Cette url doit retourner une liste de tous les foyers
 * desservis par la caserne. Cette liste doit regrouper les personnes par
 * adresse. Elle doit aussi inclure le nom, le numéro de téléphone et l'âge des
 * habitants, et faire figurer leurs antécédents médicaux (médicaments,
 * posologie et allergies) à côté de chaque nom
 */

/*
 * TODO :
 * http://localhost:8080/personInfo?firstName=<firstName>&lastName=<lastName>
 * Cette url doit retourner le nom, l'adresse, l'âge, l'adresse mail et les
 * antécédents médicaux (médicaments, posologie, allergies) de chaque habitant.
 * Si plusieurs personnes portent le même nom, elles doivent toutes apparaître.
 */
