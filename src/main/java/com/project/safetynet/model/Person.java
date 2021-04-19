
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
@Table(name = "Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@NamedQuery(name = "Person.findEmail", query = "SELECT email FROM com.project.safetynet.model.Person  WHERE id = ?1")
//@Table(name = "persons") => fonctionne
public class Person {

	@Id // chaque entité doit avoir une ID
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

//    @OneToMany
//    @JoinTable( name = "Jointure",
//                joinColumns = @JoinColumn( name = "idMedicalRecord" ),
//                inverseJoinColumns = @JoinColumn( name = "idPerson" ) )
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String zip;
	private String phone;
	private String email;
}