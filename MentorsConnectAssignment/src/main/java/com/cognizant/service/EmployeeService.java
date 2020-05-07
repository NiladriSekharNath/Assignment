package com.cognizant.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Employee;
import com.cognizant.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	

}
