package com.cognizant.userValidator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cognizant.model.*;

@Component
public class UserValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors err) {

		ValidationUtils.rejectIfEmpty(err, "userName", "user.userName.empty");
		ValidationUtils.rejectIfEmpty(err, "password", "user.password.empty");
		

		User user = (User) obj;
		
		Pattern pattern = Pattern.compile("((?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%!]).{10})",Pattern.CASE_INSENSITIVE);

		if (!(pattern.matcher(user.getPassword()).matches())) {
			err.rejectValue("password", "user.password.invalid");
		}

	}
}
