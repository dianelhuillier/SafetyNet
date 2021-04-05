
package com.project.safetynet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.safetynet.model.Firestation;

@Repository
public interface FirestationRepository extends JpaRepository<Firestation, Long> {

	List<Firestation> findByStation(String station);

}