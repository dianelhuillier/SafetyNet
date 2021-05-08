
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
	private String phone;
	private String stations;
	private String medications;
	private String allergies;
	List<Person> persons; // attribut
	private int numberAdults;
	private int numberChilds;
}