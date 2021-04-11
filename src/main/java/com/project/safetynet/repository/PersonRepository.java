package com.project.safetynet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.safetynet.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	/**
	 * Finds persons by using the last name as a search criteria.
	 * 
	 * @param email
	 * @return A list of persons which last name is an exact match with the given
	 *         last name. If no persons is found, this method returns an empty list.
	 */
//	public List<Person> findByEmail(String email);

//	@Query(SELECT email FROM person WHERE id = ?)
//	List<Person> findEmail();

//	public static PersonService personService = new PersonService();
	// Collection<? extends Person> findByPhone(String phone);

	List<Person> findByAddress(String address);

	List<Person> findByCity(String city);

	List<Person> findPersonByFirstName(String firstName);

//	List<Person> findEmail();

//	List<Person> findByStation(String station);

	// public List<Person[]> findEmail();

//	public Person getPersonByEmail(String email) {
//		  Query query = sessionFactory.getCurrentSession().createQuery("from Person where email = :email");
//		  query.setParameter("email", email);
//		  return (Person) query.list().get(0);
//		}

}