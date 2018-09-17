package com.noize.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.noize.entity.enumeration.Role;
import com.noize.validator.CheckIfFollowerEmailExists;
import com.noize.validator.CheckPasswordsMatch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@CheckPasswordsMatch
public class RegisterRequest {

	//@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Typed email has not correct format")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9\\.]+@[a-zA-Z]+\\.[a-zA-Z]{2,5}", message = "Wrong email")
	@CheckIfFollowerEmailExists
	@NotEmpty private String email;
	@NotEmpty private String firstName;
	@NotEmpty private String lastName;
	@NotEmpty private String password;
	@NotEmpty private String passwordConfirmation;
	private Role role;

}
