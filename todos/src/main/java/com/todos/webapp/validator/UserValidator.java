package com.todos.webapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.todos.webapp.models.User;

public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}
	
}
