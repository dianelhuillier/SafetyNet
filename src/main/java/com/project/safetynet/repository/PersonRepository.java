package com.project.safetynet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.safetynet.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByAddress(String address);

	List<Person> findByCity(String city);

	List<Person> findPersonByFirstName(String firstName);

	List<Person> findByLastName(String lastName);

}