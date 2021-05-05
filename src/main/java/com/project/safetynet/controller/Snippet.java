//package com.project.safetynet.controller;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.project.safetynet.PersonNotFoundException;
//import com.project.safetynet.model.Person;
//
//public class Snippet {
//
//	@PostMapping("/persons")
//	Person newPerson(@RequestBody Person newPerson) {
//		return repository.save(newPerson);
//	}
//
//	@GetMapping("/persons/{id}")
//	Person one(@PathVariable Long id) {
//		return repository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
//	}
//
//	@PutMapping("/persons/{id}")
//	Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {
//		return repository.findById(id).map(person -> {
//			person.setFirstName(newPerson.getFirstName());
//			person.setLastName(newPerson.getLastName());
//			person.setAddress(newPerson.getAddress());
//			person.setCity(newPerson.getCity());
//			person.setEmail(newPerson.getEmail());
//			person.setPhone(newPerson.getPhone());
//			person.setZip(newPerson.getZip());
//			return repository.save(person);
//		}).orElseGet(() -> {
//			newPerson.setId(id);
//			return repository.save(newPerson);
//		});
//	}
//
//	@DeleteMapping("/persons/{id}")
//	void deletePerson(@PathVariable Long id) {
//		repository.deleteById(id);
//	}
//}
