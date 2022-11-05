package com.user.UserService.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.UserService.Entity.User_1;
import com.user.UserService.reposotory.UserReposotory;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	UserReposotory userRepo;

	public User_1 saveUser(User_1 user) {
		log.info("in User Service method");
		return userRepo.save(user);
	}

	public Optional<User_1> getUserById(Long userId) {
		return userRepo.findById(userId);
	}

}
