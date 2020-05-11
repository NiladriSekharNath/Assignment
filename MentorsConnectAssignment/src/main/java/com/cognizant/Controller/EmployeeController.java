package com.cognizant.Controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.model.Employee;
import com.cognizant.service.AddressService;
import com.cognizant.service.EmployeeService;
import com.google.gson.Gson;

@Controller
public class EmployeeController {
	
	@Autowired
	private AddressService addressService;
	@Autowired
	private EmployeeService employeeService;
	
	public static final Logger LOGGER=LoggerFactory.getLogger(EmployeeController.class); 

	@GetMapping("test")
	public String getEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		Set<String> countryList = addressService.getAllCountries();
		model.addAttribute("countryList", countryList);
		
		

		return "registrationForm";

	}
	@ResponseBody
	@GetMapping("loadStatesByCountry/{country}")
	public String loadStatesByCountry(@PathVariable("country")String country) {
		Gson gson=new Gson();
		Set<String> set = addressService.getAllStatesByCountry(country);
		LOGGER.debug(":{}",set);
		System.out.println(set);
		return gson.toJson(set);
		
	}
	@ResponseBody
	@GetMapping("loadCitiesByCountryAndState/{country}/{state}")
	public String loadCitiesByStatesAndCountry(@PathVariable("country")String country,@PathVariable("state")String state) {
		Gson gson=new Gson();
		return gson.toJson(addressService.getAllCitiesByCountryAndState(country, state));
	}
	

	@PostMapping("saveEmployee")
	public String saveNewEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.addEmployee(employee);
		return "welcome";
	}

}
