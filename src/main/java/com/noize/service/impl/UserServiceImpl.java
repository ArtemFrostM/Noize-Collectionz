package com.noize.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.noize.entity.UserEntity;
import com.noize.repository.UserRepository;
import com.noize.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired 
	private UserRepository repository;
	@Autowired
	private PasswordEncoder encoder;
	
	
	@Override
	public void saveUser(UserEntity entity) {
		
		String methodName = "saveUser";
		log.debug("Start" + methodName);
		
		String password = entity.getPassword();
		entity.setPassword(encoder.encode(password));
		repository.save(entity);
		
		log.debug("End" + methodName);
	}

	@Override
	public UserEntity findUserById(int id) {
		return repository.findOne(id);
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		return repository.findUserByEmail(email);
	}

	@Override
	public void editUser(UserEntity entity) {
		repository.save(entity);
	}

	@Override
	public List<UserEntity> findAllUsers() {
		return repository.findAll();
	}

}
