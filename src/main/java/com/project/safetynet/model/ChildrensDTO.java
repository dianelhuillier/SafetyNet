package com.project.safetynet.model;

import java.util.List;

import org.junit.Ignore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildrensDTO { // data transfert object

	private String firstName;
	private String lastName;
	private String birthdate;
//	private List<String> medications = null;
//	private List<String> allergies = null;
	List<Person> persons; // attribut
}
