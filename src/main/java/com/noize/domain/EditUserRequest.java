package com.noize.domain;

import javax.persistence.Column;

import org.springframework.web.multipart.MultipartFile;

import com.noize.entity.enumeration.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class EditUserRequest {
	private int id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private int age;
	private MultipartFile file;
	private Role role;
	private String nickname;
}
