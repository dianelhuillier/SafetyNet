package com.project.safetynet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonInfoDTO {
	private String lastName;
	private String firstName;
	private String address;
	private String email;
	private long age;

}
