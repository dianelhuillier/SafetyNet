package com.project.safetynet.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.safetynet.model.Person;
import com.project.safetynet.repository.PersonRepository;

import lombok.Data;

@Data
@Service

public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Optional<Person> getPersonById(final Long id) {
		return personRepository.findById(id);
	}
//	public List<Person> getPersonsByAddress(final String address) {
//		return personRepository.findByAddress(address);
//	}

	public Iterable<Person> getPersons() {
		return personRepository.findAll();
	}

	public void deletePersonById(final Long id) {
		personRepository.deleteById(id);
	}

	public List<Person> getPersonsByCity(String city) {
		return personRepository.findByCity(city);
	}

	public List<Person> getPersonByFirstName(String firstName) {
		return personRepository.findPersonByFirstName(firstName);
	}

	public List<Person> getPersonsByLastName(String lastName) {
		return personRepository.findByLastName(lastName);
	}

	public List<Person> findPersonByAddress(String address) {
		return personRepository.findByAddress(address);
	}

	public List<Person> getPhoneByFirstName(String firstName) {
		return personRepository.findPhoneByFirstName(firstName);
	}

	public Collection<? extends Person> getPersonsByAddress(String address) {
		return personRepository.findByAddress(address);
	}

//	public List<Person> findByFirstNameAndLastName(String firstName, String lastName) {
//		return personRepository.findByFirstNameAndLastName(firstName, lastName);
//	}

	public Person savePerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return savedPerson;
	}

}