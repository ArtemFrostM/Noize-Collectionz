package com.noize.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.noize.service.UserService;


public class CheckingIfFollowerEmailsExistsValidator implements ConstraintValidator<CheckIfFollowerEmailExists, String>{
	
	@Autowired
	private UserService service;
	
	@Override
	public void initialize(CheckIfFollowerEmailExists arg0) {	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return service.findUserByEmail(email) != null ? false : true;
	}

}
