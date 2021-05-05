package com.project.safetynet;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.safetynet.service.PersonService;

@SpringBootApplication
public class Application {

	@Autowired
	private static PersonService personService;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);

//		String filePath = "src/main/resources/data.json";
//		byte[] bytesFile = Files.readAllBytes(new File(filePath).toPath());
//
//		JsonIterator iter = JsonIterator.parse(bytesFile);
//
//		Any any = iter.readAny();
//
//		Any personAny = any.get("persons");
//		List<Person> persons = new ArrayList<>();
//		personAny.forEach(a -> persons.add(new Person.PersonBuilder().firstName(a.get("firstName").toString())
//				.address(a.get("address").toString()).city(a.get("city").toString())
//				.lastName(a.get("lastName").toString()).phone(a.get("phone").toString()).zip(a.get("zip").toString())
//				.email(a.get("email").toString()).build()));
//
//		persons.forEach(person -> personService.savePerson(person));

		// any firestationsAny = any.get("firestations")
		// list<firestation> = new ArrayList<>();

	}

}
