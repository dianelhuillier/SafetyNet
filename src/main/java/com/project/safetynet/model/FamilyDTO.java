package com.project.safetynet.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class FamilyDTO {

	private String firstName;
	private String lastName;
	private long age;
//	private List<Person> family;

//	private String address;
//	private String city;
//	private String zip;
	private String phone;
//	private String email;
	private String stations;
	private String medications;
	private String allergies;

	List<Person> persons; // attribut
	private int numberAdults;
	private int numberChilds;
}
