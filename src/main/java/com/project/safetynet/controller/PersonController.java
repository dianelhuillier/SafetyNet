package com.project.safetynet.controller;

//UN LOG POUR CHAQUE ENDPOINT ET LES TESTS UNITAIRES A 80%

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.safetynet.model.ChildrensDTO;
import com.project.safetynet.model.FamilyDTO;
import com.project.safetynet.model.Firestation;
import com.project.safetynet.model.ListByStationDTO;
import com.project.safetynet.model.MedicalRecord;
import com.project.safetynet.model.Person;
import com.project.safetynet.model.PersonInfoDTO;
import com.project.safetynet.repository.PersonRepository;
import com.project.safetynet.service.FirestationService;
import com.project.safetynet.service.MedicalRecordService;
import com.project.safetynet.service.PersonService;
import com.project.safetynet.util.Util;

@RestController
public class PersonController {
	static Log log = LogFactory.getLog(PersonController.class.getName());

	@Autowired
	private PersonService personService;
	@Autowired
	private FirestationService firestationService;
	@Autowired
	private MedicalRecordService medicalRecordService; // injection de dependance
	@Autowired
	private final PersonRepository repository;

	PersonController(PersonRepository repository) {
		this.repository = repository;
	}

	// TODO : ENDPOINTS ?? PASSER DANS SERVICE ET REPO => MVC

	/**
	 * Read - Get all persons
	 * 
	 * @return - An Iterable object of Person full filled
	 */

// TODO : VERIFIER
	@PostMapping("/persons/firstName=<firstName>&lastName=<lastName>")
	Person newPerson(@RequestBody Person newPerson) {
		return repository.save(newPerson);
	}

	@PostMapping("/persons")
	public Person createPerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}

	@GetMapping("/persons")
	public Iterable<Person> getPersons() {
		return personService.getPersons();
	}

	@GetMapping("/persons/firstName=<firstName>&lastName=<lastName>")
	List<Person> one(@PathVariable String firstName, @PathVariable String lastName) {
		return repository.findPersonByFirstNameAndLastName(firstName, lastName);
	}

	@PutMapping("/persons/firstName=<firstName>&lastName=<lastName>")
	public @ResponseBody ResponseEntity<String> put() {
		return new ResponseEntity<String>("PUT Response", HttpStatus.OK);
	}

	@PutMapping("/persons/{id}")
	public Person updatePerson(@PathVariable("id") final Long id, @RequestBody Person person) {
		Optional<Person> e = personService.getPersonById(id);
		if (e.isPresent()) {
			Person currentPerson = e.get();

			String firstName = person.getFirstName();
			if (firstName != null) {
				currentPerson.setFirstName(firstName);
			}
			String lastName = person.getLastName();
			if (lastName != null) {
				currentPerson.setLastName(lastName);
				;
			}
			String address = person.getAddress();
			if (address != null) {
				currentPerson.setAddress(address);
			}
			String city = person.getCity();
			if (city != null) {
				currentPerson.setCity(city);
				;
			}
			String zip = person.getZip();
			if (zip != null) {
				currentPerson.setZip(zip);
				;
			}
			String phone = person.getPhone();
			if (phone != null) {
				currentPerson.setPhone(phone);
				;
			}
			String email = person.getEmail();
			if (email != null) {
				currentPerson.setEmail(email);
				;
			}
			personService.savePerson(currentPerson);
			return currentPerson;
		} else {
			return null;
		}
	}

	/*
	 * @DeleteMapping("/persons/firstName=<firstName>&lastName=<lastName>") void
	 * deletePerson(@PathVariable String firstName, @PathVariable String lastName) {
	 * repository.deleteByFirstNameAndLastName(firstName, lastName); }
	 */
	@DeleteMapping("/persons/{id}")
	public void deletePerson(@PathVariable("id") final Long id) {
		personService.deletePersonById(id);
	}

	/**
	 * TODO : OK http://localhost:8080/firestation?stationNumber=%3Cstation_number
	 * Cette url doit retourner une liste des personnes couvertes par la caserne de
	 * pompiers correspondante. La liste doit inclure les informations spécifiques
	 * suivantes : prénom, nom, adresse, numéro de téléphone. De plus, elle doit
	 * fournir un décompte du nombre d'adultes et du nombre d'enfants (tout individu
	 * âgé de 18 ans ou moins) dans la zone desservie.
	 */

//	@GetMapping("/firestation")
//	public List<FamilyDTO> getPersonByStationNumber(@RequestParam(value = "stationNumber") String station){
//		List<Firestation> firestations = firestationService.getFirestationByStation(station);
//		
//		List<FamilyDTO> persons= new ArrayList<>();
//
//for (Firestation firestation : firestations) {
//	persons.add((FamilyDTO) personService.findPersonByAddress(firestation.getAddress()));
//		}
//for (FamilyDTO person : persons) {
//	int numberAdults = 0;
//	int numberChilds = 0;
//
//	if (Util.calculAgeByBirthdate(
//			medicalRecordService.findMedicalRecordByFirstName(person.getFirstName()).getBirthdate()) <= 18) {
//		numberChilds++;
//	} else {
//		numberAdults++;
//	}
//	
//}
//log.info("Endpoint /firestation valide");
//		return persons;
//	}
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	@GetMapping("/firestation")
	public ListByStationDTO getPersonsByFirestationNumber(@RequestParam(value = "stationNumber") String station) {
		List<Firestation> firestations = firestationService.getFirestationByStation(station);
		List<Person> persons = new ArrayList<>();
		int numberChilds = 0;
		int numberAdults = 0;
		for (Firestation firestation : firestations) {
			persons.addAll(personService.findPersonByAddress(firestation.getAddress()));
		}
		for (Person person : persons) {
			if (Util.calculAgeByBirthdate(
					medicalRecordService.findMedicalRecordByFirstName(person.getFirstName()).getBirthdate()) <= 18) {
				numberChilds++;
			} else {
				numberAdults++;
			}

		}
		log.info("Endpoint /firestation valide");
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

		List<Person> persons = personService.findPersonByAddress(address); // retourne la liste des personnes en
																			// fonction de l'adresse qui lui correspond
		List<ChildrensDTO> childrens = new ArrayList<>();

		for (Person person : persons) {
			MedicalRecord medicalRecord = medicalRecordService.findMedicalRecordByFirstName(person.getFirstName());
			// if (medicalRecord != null &&
			// Util.calculAgeByBirthdate(medicalRecord.getBirthdate()) <= 18) {
			if (Util.calculAgeByBirthdate(medicalRecord.getBirthdate()) <= 18) {
				childrens.add(new ChildrensDTO(medicalRecord.getFirstName(), medicalRecord.getLastName(),
						medicalRecord.getBirthdate(), personService.findPersonByAddress(person.getAddress())));
			}
		}
		log.info("Endpoint /childAlert valide");
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
			persons.addAll(personService.findPersonByAddress(firestation.getAddress()));
		}
		List<String> listPhoneByStation = ((Collection<Person>) persons).stream().map(Person::getPhone)
				.collect(Collectors.toList());
		log.info("Endpoint /phoneAlert valide");
		return listPhoneByStation;
	}

	/*
	 * Cette url doit retourner la liste des habitants vivant à l’adresse donnée
	 * ainsi que le numéro de la caserne de pompiers la desservant. La liste doit
	 * inclure le nom, le numéro de téléphone, l'âge et les antécédents médicaux
	 * (médicaments, posologie et allergies) de chaque personne.
	 */
	// TODO : ok http://localhost:8080/fire?address=%3Caddress

	@GetMapping("/fire")
	public List<FamilyDTO> getInfoByAddress(@RequestParam(value = "address") String address) {
		List<FamilyDTO> family = new ArrayList<>();

		List<Person> persons = personService.findPersonByAddress(address); // retourne la liste des personnes en
		if (persons == null) {
			log.info("pas de famille existante à cette adresse");
			log.debug("il n'y a pas de famille à cette addresse");
		} else {
			log.info("il y a une famille à cette adresse");
			for (Person person : persons) {
				MedicalRecord medicalRecord = medicalRecordService.findMedicalRecordByFirstName(person.getFirstName());
				Firestation firestation = firestationService.findStationNumberByAddress(person.getAddress());
				family.add(new FamilyDTO(medicalRecord.getFirstName(), medicalRecord.getLastName(),
						Util.calculAgeByBirthdate(medicalRecord.getBirthdate()), person.getPhone(),
						firestation.getStation(), medicalRecord.getMedications(), medicalRecord.getAllergies(),
						personService.findPersonByAddress(person.getAddress()), 0, 0));

			}
		}
		log.info("Endpoint /fire valide");
		return family;

	}

	/*
	 * 
	 * /* TODO : http://localhost:8080/flood/stations?stations=<a list of
	 * station_numbers> Cette url doit retourner une liste de tous les foyers
	 * desservis par la caserne. Cette liste doit regrouper les personnes par
	 * adresse. Elle doit aussi inclure le nom, le numéro de téléphone et l'âge des
	 * habitants, et faire figurer leurs antécédents médicaux (médicaments,
	 * posologie et allergies) à côté de chaque nom
	 */

	@GetMapping("/flood/stations")
	public List<FamilyDTO> getPersonsByFirestationNumberAndAddress(@RequestParam(value = "stations") String station) {
		List<Firestation> firestations = firestationService.getFirestationByStation(station);

		List<Person> persons = new ArrayList<>();

		List<FamilyDTO> infoFlood = new ArrayList<>();
		if (firestations == null) {
			log.error("il n'y a pas de station attribuée à cette valeur");
		} else {
			for (Firestation firestation : firestations) {
				persons.addAll(personService.findPersonByAddress(firestation.getAddress()));
				log.info("liste de personnes attribuées  la caserne");
			}

			for (Person person : persons) {
				if (persons == null) {
					log.debug("personne ne vit près de cette caserne");
				} else {
					MedicalRecord medicalRecord = medicalRecordService
							.findMedicalRecordByFirstName(person.getFirstName());
					Firestation firestation = firestationService.findStationNumberByAddress(person.getAddress());

					infoFlood.add(new FamilyDTO(medicalRecord.getFirstName(), medicalRecord.getLastName(),
							Util.calculAgeByBirthdate(medicalRecord.getBirthdate()), person.getPhone(),
							firestation.getStation(), medicalRecord.getMedications(), medicalRecord.getAllergies(),
							personService.findPersonByAddress(person.getAddress()), 0, 0));
					log.info("liste de personnes attribuées à la caserne ainsi que les informations necessaires");
				}
			}
		}
		log.info("Endpoint /flood valide");
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
	public List<PersonInfoDTO> getInfos(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName) {

		List<Person> persons = personService.getPersonsByLastName(lastName);
		log.info("liste de personnes ayant le même nom de famille");
		List<PersonInfoDTO> familyName = new ArrayList<>();

		if (lastName == null) {
			log.error("nom de famille inexistant");
		} else {
			log.info("nom de famille trouvé");
			for (Person person : persons) {
				MedicalRecord medicalRecord = medicalRecordService.findMedicalRecordByFirstName(person.getFirstName());
				familyName.add(new PersonInfoDTO(person.getLastName(), person.getFirstName(), person.getAddress(),
						person.getEmail(), Util.calculAgeByBirthdate(medicalRecord.getBirthdate())));
				log.debug("personne spécifique, ses informations et sa famille");
			}
		}
		log.info("Endpoint /personInfo valide");
		return familyName;
	}

	/**
	 * http://localhost:8080/communityEmail?city=Culver TODO : OK Cette url doit
	 * retourner les adresses mail de tous les habitants de la ville
	 */

	@GetMapping("/communityEmail")
	public List<String> getEmails(@RequestParam(value = "city") String city) {
		Iterable<Person> persons = personService.getPersons();

		log.info(persons);
		List<String> listEmails = ((Collection<Person>) persons).stream().map(Person::getEmail)
				.collect(Collectors.toList());
		log.info("Endpoint /communityEmail valide");
		return listEmails;
	}

}
