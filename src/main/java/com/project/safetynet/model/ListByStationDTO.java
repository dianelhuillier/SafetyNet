package com.project.safetynet.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class ListByStationDTO {

	List<Person> persons;
	private int numberChilds;
	private int numberAdults;

}
