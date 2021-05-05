package com.project.stproject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.project.safetynet.Application;
import com.project.safetynet.controller.MedicalRecordController;
import com.project.safetynet.controller.PersonController;
import com.project.safetynet.model.ChildrensDTO;
import com.project.safetynet.model.FamilyDTO;
import com.project.safetynet.model.Firestation;
import com.project.safetynet.model.MedicalRecord;
import com.project.safetynet.model.Person;
import com.project.safetynet.model.PersonInfoDTO;
import com.project.safetynet.service.FirestationService;
import com.project.safetynet.service.MedicalRecordService;
import com.project.safetynet.service.PersonService;
import com.project.safetynet.util.Util;

@SpringBootTest(classes = Application.class)
@ContextConfiguration
public class ApplicationTests {

	@Autowired
	private PersonService personService;
	@Autowired
	private MedicalRecordService medicalRecordService;
	@Autowired
	private PersonController personController;
	@Autowired
	private FirestationService firestationService;
	@Autowired
	private MedicalRecordController medicalRecordController;

	@Test
	void contextLoads() {
	}

	// TEST COUCHE SERVICE UNITAIRes
	@Test
	public void testFindPersonByAddress() throws Exception {
		List<Person> persons = personService.findPersonByAddress("834 Binoc Ave");
		List<String> names = persons.stream().map(Person::getFirstName).collect(Collectors.toList());
		assertTrue(names.stream().anyMatch(s -> s.equals("Tessa")));
	}

	@Test
	public void testFindPersonsByCity() {
		List<Person> persons = personService.getPersonsByCity("Culver");
		List<String> list = persons.stream().map(Person::getFirstName).collect(Collectors.toList());
		assertTrue(list.stream().anyMatch(s -> s.equals("Tessa")));
	}

	@Test
	public void testFindPersonByFirstName() {
		List<Person> persons = personService.getPersonByFirstName("Tessa");
		List<String> list = persons.stream().map(Person::getAddress).collect(Collectors.toList());
		assertTrue(list.stream().anyMatch(s -> s.equals("834 Binoc Ave")));
	}

	@Test
	public void testFindPersonsByLastName() {
		List<Person> persons = personService.getPersonsByLastName("Boyd");
		List<String> list = persons.stream().map(Person::getFirstName).collect(Collectors.toList());
		assertTrue(list.stream().anyMatch(s -> s.equals("John")));
	}

	@Test
	public void testGetBirthdate() {
		List<MedicalRecord> medicalList = medicalRecordService.getBirthdate("02/18/2012");
		List<String> list = medicalList.stream().map(MedicalRecord::getFirstName).collect(Collectors.toList());
		assertTrue(list.stream().anyMatch(s -> s.equals("Tessa")));
	}

	@Test
	public void testGetEmails() {
		List<String> listEmails = personController.getEmails("Culver");
		assertTrue(listEmails.stream().anyMatch(s -> s.equals("jaboyd@email.com")));
	}

	@Test
	public void testGetPhoneByFirstName() {
		List<Person> persons = personService.getPhoneByFirstName("Tessa");
		List<String> listPhone = persons.stream().map(Person::getPhone).collect(Collectors.toList());
		assertTrue(listPhone.stream().anyMatch(s -> s.equals("841-874-6512")));
	}

	@Test
	public void testGetPersonsByFirestationNumberAndAddress() {
		List<FamilyDTO> persons = personController.getPersonsByFirestationNumberAndAddress("3");
		List<String> listByStation = persons.stream().map(FamilyDTO::getFirstName).collect(Collectors.toList());
		assertTrue(listByStation.stream().anyMatch(s -> s.equals("Tessa")));

	}

	@Test
	public void testGetInfoByAddress() {
		List<FamilyDTO> persons = personController.getInfoByAddress("834 Binoc Ave");
		List<String> infoByAddress = persons.stream().map(FamilyDTO::getFirstName).collect(Collectors.toList());
		if (infoByAddress != null) {
			assertTrue(infoByAddress.stream().anyMatch(s -> s.equals("Tessa")));
		}

	}

//	@Test
//	public void testGetInfoNullByAddress() {
//		List<FamilyDTO> persons = personController.getInfoByAddress("84 Binoc Ave");
//		List<String> infoByAddress = persons.stream().map(FamilyDTO::getFirstName).collect(Collectors.toList());
//		assertFalse(infoByAddress.stream().anyMatch(s -> s.equals("Tessa")));
//		assertTrue(infoByAddress == null);
//	}

	@Test
	public void testGetPhoneByStation() {
		List<String> firestations = personController.getPhoneByStation("3");
		assertTrue(firestations.stream().anyMatch(s -> s.equals("841-874-6512")));
	}

	@Test
	public void testGetChildByAddress() {
		List<ChildrensDTO> childs = personController.getChildByAddress("834 Binoc Ave");
		List<String> birthdateChild = childs.stream().map(ChildrensDTO::getBirthdate).collect(Collectors.toList());

		assertTrue(birthdateChild.stream().anyMatch(s -> s.equals("02/18/2012")));

		for (String birthdate : birthdateChild) {
			ArrayList<Long> ageChild = new ArrayList<Long>(Arrays.asList(Util.calculAgeByBirthdate(birthdate)));
			assertFalse(ageChild.stream().anyMatch(s -> s.compareTo(s) > 18));
			assertTrue(ageChild.stream().allMatch(s -> s.compareTo(s) < 18));
		}
	}

	@Test
	public void testGetInfos() {
		List<PersonInfoDTO> personsInfos = personController.getInfos("Tessa", "Carman");
		List<String> infos = personsInfos.stream().map(PersonInfoDTO::getEmail).collect(Collectors.toList());
		assertTrue(infos.stream().anyMatch(s -> s.equals("tenz@email.com")));

	}
//TEST A REFAIRE
//	public ListByStationDTO getPersonsByFirestationNumber(@RequestParam(value = "stationNumber") String station) {
//		// HashMap<Person, Long> listFinal = new HashMap<Person, Long>();
//		List<Firestation> firestations = firestationService.getFirestationByStation(station);
////		HashMap<Person, String> ageList = new HashMap<Person, String>();
//		List<Person> persons = new ArrayList<>();
//		int numberChilds = 0;
//		int numberAdults = 0;
//		for (Firestation firestation : firestations) {
//			persons.addAll(personService.findPersonByAddress(firestation.getAddress()));
////			Stream<List<Person>> ageList = Stream.of(persons).filter(personService.getPersonByAge()<18); //passer par medrecord pour l'age
//		}
//		for (Person person : persons) {
//			if (Util.calculAgeByBirthdate(
//					medicalRecordService.findMedicalRecordByFirstName(person.getFirstName()).getBirthdate()) <= 18) {
//				numberChilds++;
//			} else {
//				numberAdults++;
//			}
//
//		}
////		long total = persons.stream().count();
////		listFinal.put((Person) persons, total);
//		return new ListByStationDTO(persons, numberChilds, numberAdults);

	// !!!!!!!!!!!!!!!!!!
//	@Test
//	public void testGetPersonsByFirestationNumber() {
//		ListByStationDTO listPersons = new ListByStationDTO((List<Person>) personController.getPersonsByFirestationNumber("3"), 0, 0);
//	((List<Person>) listPersons).addAll((Collection<? extends Person>) new ListByStationDTO());
//		List<String> getPersons = ((Collection<Person>) listPersons).stream().map(Person::getFirstName).collect(Collectors.toList());
//		assertTrue(getPersons.stream().anyMatch(s -> s.equals("Tessa")));
//
//	}

	@Test
	public void testGetPersons() {
		Iterable<Person> persons = personController.getPersons();
		List<String> firstNames = ((Collection<Person>) persons).stream().map(Person::getFirstName)
				.collect(Collectors.toList());
		assertTrue((firstNames.stream().anyMatch(s -> s.equals("Tessa"))));
	}

	@Test
	public void testFindMedicalRecordByLastName() {
		MedicalRecord medicalRecords = medicalRecordService.findMedicalRecordByLastName("Carman");
		String list = medicalRecords.getFirstName();

		assertTrue(list.equals("Tessa"));
	}

	@Test
	public void testGetMedicalRecord() {
		Iterable<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecord();
		List<String> list = ((Collection<MedicalRecord>) medicalRecords).stream().map(MedicalRecord::getFirstName)
				.collect(Collectors.toList());
		assertTrue(list.stream().anyMatch(s -> s.equals("Tessa")));
	}

	@Test
	public void testFindByFirstNameAndLastName() {
		MedicalRecord medicalRecords = medicalRecordService.findByFirstNameAndLastName("Tessa", "Carman");
		String list = medicalRecords.getBirthdate();
		assertTrue(list.equals("02/18/2012"));
	}

	@Test
	public void testFindStationNumberByAddress() {
		Firestation firestations = firestationService.findStationNumberByAddress("834 Binoc Ave");
		String list = firestations.getStation();
		assertTrue(list.equals("3"));
	}

//@Test
//public void testPersonNotFoundException() {
//	Optional<Person> persons = personService.getPersonById(null);
//	
//	assertThrows(PersonNotFoundException.class, () ->{
//		  Long.parseLong("0");
//	}); 
////	List<Long> list = (persons).stream().map(Person::getId).collect(Collectors.toList());
////	assertTrue(list.equals(1));
//}
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//	@Test
//	public void testGetPersonById() {
//		Optional<Person>persons = personService.getPersonById((long) 1);
//		List<String>list = persons.stream().map(Person::getFirstName).collect(Collectors.toList());
//		assertTrue(list.stream().anyMatch(s -> s.equals("John")));
//	}
	@Test
	public void testGetPersonsByAddress() {
		Collection<? extends Person> persons = personService.getPersonsByAddress("834 Binoc Ave");
		List<String> list = persons.stream().map(Person::getFirstName).collect(Collectors.toList());
		assertTrue(list.stream().anyMatch(s -> s.equals("Tessa")));
	}

	@Test
	public void testGetMedicalRecordController() {
		Iterable<MedicalRecord> medicalRecord = medicalRecordController.getMedicalRecord();
		List<String> list = (((Collection<MedicalRecord>) medicalRecord).stream().map(MedicalRecord::getFirstName)
				.collect(Collectors.toList()));
		assertTrue(list.stream().anyMatch(s -> s.equals("Tessa")));
	}

//	public Person savePerson(Person person) {
//		Person savedPerson = personRepository.save(person);
//		return savedPerson;
//	}

}
