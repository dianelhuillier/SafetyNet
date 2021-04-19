package com.project.safetynet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalRecordController {

	@Autowired
	private MedicalRecordController medicalRecordController;

	@GetMapping
	public MedicalRecordController getMedicalRecordController() {
		return medicalRecordController;
	}
	/*
	 * TODO : http://localhost:8080/childAlert?address=<address> Cette url doit
	 * retourner une liste d'enfants (tout individu âgé de 18 ans ou moins) habitant
	 * à cette adresse. La liste doit comprendre le prénom et le nom de famille de
	 * chaque enfant, son âge et une liste des autres membres du foyer. S'il n'y a
	 * pas d'enfant, cette url peut renvoyer une chaîne vide.
	 */
//	@GetMapping("/childAlert")
//	public List<MedicalRecord> getChildByAddress(@RequestParam(value = "address") String address) {
//		List<Person> persons = personService.getPersonsByAddress(address);
//				
//		
//		return null;
//	}
}