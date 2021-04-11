
package com.project.safetynet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@NamedQuery(name = "Person.findEmail", query = "SELECT email FROM com.project.safetynet.model.Person  WHERE id = ?1")
//@Table(name = "persons") => fonctionne
public class Person {

	@Id // chaque entité doit avoir une ID
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String zip;
	private String phone;
	private String email;

}