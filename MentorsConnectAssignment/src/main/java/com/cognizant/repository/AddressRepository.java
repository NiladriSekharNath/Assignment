package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	public List<Address> findByCountry(String country);
	public List<Address> findByCountryAndState(String country, String state);

}
