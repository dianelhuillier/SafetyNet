
package com.project.safetynet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MedicalRecord")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {
//TODO : activer les listes medications et allergies
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;
	private String birthdate;
	private String medications;
	private String allergies;
//	private List<String> medications = null;
//	private List<String> allergies = null;

}