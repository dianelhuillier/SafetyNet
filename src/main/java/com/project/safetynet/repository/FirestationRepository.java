
package com.project.safetynet.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.safetynet.model.Firestation;
import com.project.safetynet.model.Person;

@Repository
public interface FirestationRepository extends JpaRepository<Firestation, Long> {

	List<Firestation> findByStation(String station);

	Collection<? extends Person> findByAddress(String address);

	Firestation findStationByAddress(String address);

	void deleteByAddress(String address);

}