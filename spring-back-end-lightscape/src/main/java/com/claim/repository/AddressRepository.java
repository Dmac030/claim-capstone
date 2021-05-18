package com.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claim.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

}
