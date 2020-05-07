package com.cognizant.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Address;
import com.cognizant.repository.AddressRepository;
@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;

	@Transactional
	public Set<String> getAllCountries() {
		List<Address> addressList = addressRepository.findAll();
		Set<String> countryList = new HashSet<String>();
		for (Address address : addressList)
			countryList.add(address.getCountry());

		return countryList;
	}

	@Transactional
	public Set<String> getAllStatesByCountry(String country) {
		List<Address> addressList = addressRepository.findByCountry(country);
		Set<String> stateList = new HashSet<String>();
		for (Address address : addressList)
			stateList.add(address.getState());

		return stateList;
	}

	@Transactional
	public Set<String>getAllCitiesByCountryAndState(String country,String state){
	List<Address> addressList = addressRepository.findByCountryAndState(country, state);
	Set<String>cityList=new HashSet<String>();
	for(Address address:addressList) 
		cityList.add(address.getCity());
	return cityList;	
	}
}


