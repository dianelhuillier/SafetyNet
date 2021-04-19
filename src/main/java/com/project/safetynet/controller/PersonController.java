package com.project.safetynet.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.safetynet.PersonNotFoundException;
import com.project.safetynet.model.ChildrensDTO;
import com.project.safetynet.model.FamilyDTO;
import com.project.safetynet.model.Firestation;
import com.project.safetynet.model.ListByStationDTO;
import com.project.safetynet.model.MedicalRecord;
import com.project.safetynet.model.Person;
import com.project.safetynet.repository.PersonRepository;
import com.project.safetynet.service.FirestationService;
import com.project.safetynet.service.MedicalRecordService;
import com.project.safetynet.service.PersonService;
import com.project.safetynet.util.Util;

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
	@Autowired
	private MedicalRecordService medicalRecordService; // injection de dependance

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
	 * TODO : OK http://localhost:8080/firestation?stationNumber=%3Cstation_number
	 * Cette url doit retourner une liste des personnes couvertes par la caserne de
	 * pompiers correspondante. Donc, si le numéro de station = 1, elle doit
	 * renvoyer les habitants couverts par la station numéro 1. La liste doit
	 * inclure les informations spécifiques suivantes : prénom, nom, adresse, numéro
	 * // new classe infos de téléphone. De plus, elle doit fournir un décompte du
	 * nombre d'adultes et du nombre d'enfants (tout individu âgé de 18 ans ou
	 * moins) dans la zone desservie.
	 */
	@GetMapping("/firestation")
	public ListByStationDTO getPersonsByFirestationNumber(@RequestParam(value = "stationNumber") String station) {
		// HashMap<Person, Long> listFinal = new HashMap<Person, Long>();
		List<Firestation> firestations = firestationService.getFirestationByStation(station);
//		HashMap<Person, String> ageList = new HashMap<Person, String>();
		List<Person> persons = new ArrayList<>();
		int numberChilds = 0;
		int numberAdults = 0;
		for (Firestation firestation : firestations) {
			persons.addAll(personService.getPersonsByAddress(firestation.getAddress()));
//			Stream<List<Person>> ageList = Stream.of(persons).filter(personService.getPersonByAge()<18); //passer par medrecord pour l'age

		}

		for (Person person : persons) {
			if (Util.calculAgeByBirthdate(
					medicalRecordService.findMedicalRecordByFirstName(person.getFirstName()).getBirthdate()) <= 18) {
				numberChilds++;
			} else {
				numberAdults++;
			}

		}
//		long total = persons.stream().count();
//		listFinal.put((Person) persons, total);
		return new ListByStationDTO(persons, numberChilds, numberAdults);
	}

	/*
	 * TODO : ok http://localhost:8080/childAlert?address=<address> Cette url doit
	 * retourner une liste d'enfants (tout individu âgé de 18 ans ou moins) habitant
	 * à cette adresse. La liste doit comprendre le prénom et le nom de famille de
	 * chaque enfant, son âge et une liste des autres membres du foyer. S'il n'y a
	 * pas d'enfant, cette url peut renvoyer une chaîne vide.
	 */
	@GetMapping("/childAlert")
	public List<ChildrensDTO> getChildByAddress(@RequestParam(value = "address") String address) {

		List<Person> persons = personService.getPersonsByAddress(address); // retourne la liste des personnes en
																			// fonction de l'adresse qui lui correspond
		List<ChildrensDTO> childrens = new ArrayList<>();

		for (Person person : persons) {
			MedicalRecord medicalRecord = medicalRecordService.findMedicalRecordByFirstName(person.getFirstName());
			if (medicalRecord != null && Util.calculAgeByBirthdate(medicalRecord.getBirthdate()) <= 18) {
				childrens.add(new ChildrensDTO(medicalRecord.getFirstName(), medicalRecord.getLastName(),
						medicalRecord.getBirthdate(), personService.getPersonsByAddress(person.getAddress())));
			}
		}

		return childrens;

	}

	/*
	 * TODO : OK http://localhost:8080/phoneAlert?firestation=<firestation_number>
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

	/*
	 * Cette url doit retourner la liste des habitants vivant à l’adresse donnée
	 * ainsi que le numéro de la caserne de pompiers la desservant. La liste doit
	 * inclure le nom, le numéro de téléphone, l'âge et les antécédents médicaux
	 * (médicaments, posologie et allergies) de chaque personne.
	 */
	// TODO : http://localhost:8080/fire?address=%3Caddress

	@GetMapping("/fire")
	public List<Person> getInfoByAddress(@RequestParam(value = "address") String address) {
		List<FamilyDTO> family = new ArrayList<>();

		List<Person> persons = personService.getPersonsByAddress(address); // retourne la liste des personnes en

		for (Person person : persons) {
			MedicalRecord medicalRecord = medicalRecordService.findMedicalRecordByFirstName(person.getFirstName());
			Firestation firestation = firestationService.findStationNumberByAddress(person.getAddress());
			family.add(new FamilyDTO(medicalRecord.getFirstName(), medicalRecord.getLastName(),
					Util.calculAgeByBirthdate(medicalRecord.getBirthdate()), person.getPhone(),
					firestation.getStation(), personService.getPersonsByAddress(person.getAddress())));

		}

		return persons;

	}

	/*
	 * fonctionne avec http://localhost:8080/flood?stations=3
	 * 
	 * /* TODO : http://localhost:8080/flood/stations?stations=<a list of
	 * station_numbers> Cette url doit retourner une liste de tous les foyers
	 * desservis par la caserne. Cette liste doit regrouper les personnes par
	 * adresse. Elle doit aussi inclure le nom, le numéro de téléphone et l'âge des
	 * habitants, et faire figurer leurs antécédents médicaux (médicaments,
	 * posologie et allergies) à côté de chaque nom
	 */
	@GetMapping("/flood")
	public Stream<String> getPersonsByFirestationNumberAndAddress(@RequestParam(value = "stations") String station) {
		List<Firestation> firestations = firestationService.getFirestationByStation(station);
		List<Person> persons = new ArrayList<>();
		for (Firestation firestation : firestations) {
			persons.addAll(personService.getPersonsByAddress(firestation.getAddress()));
		}
		Stream<String> infoFlood = ((Collection<Person>) persons).stream().map(Person::getLastName);
		((Collection<Person>) persons).stream().map(Person::getPhone).collect(Collectors.toList());

		return infoFlood;
	}

	/*
	 * TODO : personInfo
	 * http://localhost:8080/personInfo?firstName=<firstName>&lastName=<lastName>
	 * Cette url doit retourner le nom, l'adresse, l'âge, l'adresse mail et les
	 * antécédents médicaux (médicaments, posologie, allergies) de chaque habitant.
	 * Si plusieurs personnes portent le même nom, elles doivent toutes apparaître.
	 */
//	public List<Person> getInflos(String fn, String ln) {
//		
//	}

	@GetMapping("/personInfo")
	public List<ChildrensDTO> getInfos(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName) {
		List<Person> persons = personService.getPersonsByLastName(lastName);
		List<ChildrensDTO> familyName = new ArrayList<>();
		for (Person person : persons) {
			MedicalRecord medicalRecord = medicalRecordService.findMedicalRecordByLastName(person.getLastName());
			if (personService.getPersonsByLastName(lastName) != null) {
				familyName.add(new ChildrensDTO(medicalRecord.getFirstName(), medicalRecord.getLastName(),
						medicalRecord.getBirthdate(), persons));
			}

		}

		return familyName;
	}

	/**
	 * http://localhost:8080/communityEmail?city=Culver TODO : OK Cette url doit
	 * retourner les adresses mail de tous les habitants de la ville
	 */

	@GetMapping("/communityEmail")
	public List<String> getEmails(@RequestParam(value = "city") String city) {
		Iterable<Person> persons = personService.getPersons();
		List<String> listEmails = ((Collection<Person>) persons).stream().map(Person::getEmail)
				.collect(Collectors.toList());

		return listEmails;

	}

	// TODO : ENDPOINTS ?? PASSER DANS SERVICE ET REPO => MVC
	private final PersonRepository repository;

	PersonController(PersonRepository repository) {
		this.repository = repository;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/persons")
	List<Person> all() {
		return repository.findAll();
	}
	// end::get-aggregate-root[]

	@PostMapping("/persons")
	Person newPerson(@RequestBody Person newPerson) {
		return repository.save(newPerson);
	}

	// Single item

	@GetMapping("/persons/{id}")
	Person one(@PathVariable Long id) {

		return repository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}

	@PutMapping("/persons/{id}")
	Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {

		return repository.findById(id).map(person -> {
			person.setFirstName(newPerson.getFirstName());
			person.setLastName(newPerson.getLastName());

			return repository.save(person);
		}).orElseGet(() -> {
			newPerson.setId(id);
			return repository.save(newPerson);
		});
	}

	@DeleteMapping("/persons/{id}")
	void deletePerson(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
