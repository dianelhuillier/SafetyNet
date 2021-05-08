package com.project.safetynet.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildrensDTO { // data transfert object

	private String firstName;
	private String lastName;
	private String birthdate;
	List<Person> persons; // attribut
}
