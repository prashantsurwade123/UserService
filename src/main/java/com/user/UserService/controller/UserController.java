package com.user.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.UserService.Entity.User_1;
import com.user.UserService.Service.UserService;
import com.user.UserService.VO.Department;
import com.user.UserService.VO.UserDeptVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	RestTemplate restTemplate;

	/**
	 * This is save user in DB
	 * @param user
	 * @return
	 */
	@PostMapping("/user")
	public User_1 saveUser(@RequestBody User_1 user) {
		log.info("in user controller method");
		return userService.saveUser(user);

	}

	/**
	 * get user object wrt Id
	 * @param userId
	 * @return
	 */
	@GetMapping("/user/{userId}")
	public UserDeptVO getUserById(@PathVariable("userId") Long userId) {
		log.info("in user controller method");
		User_1 user= userService.getUserById(userId).get();
		
		Department dept = restTemplate.getForObject("http://DEPARMENT-SERVICE/department/1", Department.class);
		
		UserDeptVO userDeptVO = new UserDeptVO();
		userDeptVO.setDeptId(dept.getDeptId());
		userDeptVO.setDeptName(dept.getDeptName());
		userDeptVO.setUserFirstName(user.getUserFirstName());
		userDeptVO.setUserLastName(user.getUserLastName());
		
		return userDeptVO;
	}

}
