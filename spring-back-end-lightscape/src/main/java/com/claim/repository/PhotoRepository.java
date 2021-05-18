package com.claim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.claim.entity.Photo;

@Repository
public interface PhotoRepository extends JpaRepository <Photo, String >{

@Query("Select P from Photo P where P.photographer.email =?1")
public List<Photo> findByEmail(String email);
	
}
