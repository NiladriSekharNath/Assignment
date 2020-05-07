package com.cognizant.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.model.Employee;
import com.cognizant.model.Address;
import com.cognizant.model.User;
import com.cognizant.service.AddressService;
import com.cognizant.service.EmployeeService;
import com.cognizant.service.UserService;
import com.cognizant.userValidator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private UserService userService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private AddressService addressService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}

	@GetMapping("getUser")
	public String userForm(Locale locale, Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	/*
	 */
	@PostMapping("saveUser")
	public String saveUser(@ModelAttribute("user") @Validated User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "login";// Redirecting to input page
		} else {
			if (!userService.checkUser(user)) {
				model.addAttribute("Message", "User not Found");
				return "login";// Redirecting to input page
			} else {
				model.addAttribute("userName", user.getUserName());
				return "welcome";
			}
		}
	}

	@GetMapping()
	public String getEmployeeForm(@ModelAttribute("employee") Model model) {
		model.addAttribute("employee", new Employee());
		Set<String> countryList = addressService.getAllCountries();
		model.addAttribute("countryList", countryList);
		for (String country : countryList) {
			Set<String> stateList = addressService.getAllStatesByCountry(country);
			model.addAttribute("stateList", stateList);
			for (String state : stateList) {
				Set<String> cityList = addressService.getAllCitiesByCountryAndState(country, state);
				model.addAttribute("cityList", cityList);
			}
		}

		return "RegistrationForm";

	}

	@PostMapping("saveEmployee")
	public String saveNewEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.addEmployee(employee);
		return "welcome";
	}

}
