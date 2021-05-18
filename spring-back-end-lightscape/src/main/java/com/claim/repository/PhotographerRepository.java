package com.claim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claim.entity.Photographer;


@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, String> {

	
	
	@Query("Select P from Photographer P where P.userName =?1 and P.password =?2")
	public Photographer login(String userName, String password);
	
	
	@Query("From Photographer P where P.userName LIKE ?1 OR P.firstName LIKE ?1 OR P.lastName LIKE ?1")
	List<Photographer> findByName(String userName);
	

	
	
}
	
