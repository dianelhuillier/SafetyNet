package com.project.safetynet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.safetynet.model.Person;
import com.project.safetynet.repository.PersonRepository;

import lombok.Data;
//une couche pour chaque

@Data
@Service

public class PersonService {

	// PersonService

	@Autowired
	private PersonRepository personRepository;

	public Optional<Person> getPersonById(final Long id) {
		return personRepository.findById(id);
	}

	public List<Person> getPersonsByAddress(final String address) {
		return personRepository.findByAddress(address);
	}

	public Iterable<Person> getPersons() {
		return personRepository.findAll();
	}

	public void deletePersonById(final Long id) {
		personRepository.deleteById(id);
	}

	public Person savePerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return savedPerson;
	}

//	public Collection<? extends Person> getPhoneByStation(String phone) {
//		// TODO Auto-generated method stub
//		return personRepository.findByPhone(phone);
//	}
//	public List<Person> getPhoneByStation(final String phone) {
//		return personRepository.findByStation(phone);
//
//	}

}