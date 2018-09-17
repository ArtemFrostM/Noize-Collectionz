package com.noize.service;

import java.util.List;

import com.noize.entity.UserEntity;

public interface UserService {

	void saveUser(UserEntity entity);
	
	void editUser(UserEntity entity);
	
	UserEntity findUserById(int id);
	
	UserEntity findUserByEmail(String email);
	
	List<UserEntity> findAllUsers();
}
