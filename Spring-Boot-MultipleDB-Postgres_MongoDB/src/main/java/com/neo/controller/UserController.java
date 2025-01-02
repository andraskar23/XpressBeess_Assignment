package com.neo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.postgresdb.entity.UserEntity;
import com.neo.postgresdb.repo.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/add-user")
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user) {
		UserEntity userSaved = userRepo.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
	}

	@GetMapping("/get-all/user")
	public ResponseEntity<List<UserEntity>> getAllUser() {
		List<UserEntity> allUser = (List<UserEntity>) userRepo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(allUser);
	}
	
}
