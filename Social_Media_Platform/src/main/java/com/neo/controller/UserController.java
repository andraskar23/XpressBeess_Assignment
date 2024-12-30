package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.dto.UserDto;
import com.neo.exception.UserNotFoundException;
import com.neo.model.User;
import com.neo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/createuser")
	public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
		
		User user = new User();
		user.setAge(userDto.getAge());
		user.setUname(userDto.getUname());
		
		String res = userService.createUser(user);
		
		return new ResponseEntity<>(res , HttpStatus.CREATED);
	}
	
	@PostMapping("/notification/{userid}")
	public ResponseEntity<?> getNotification(@PathVariable("userid") Integer userId) throws UserNotFoundException{
		return new ResponseEntity<>(userService.getNotification(userId), HttpStatus.OK);
		
	}

}
