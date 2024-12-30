package com.neo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.neo.exception.UserNotFoundException;
import com.neo.model.Notification;
import com.neo.model.User;
import com.neo.repo.PostRepo;
import com.neo.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	private UserRepo userRepo;

	public UserService(UserRepo userRepo, PostRepo postRepo) {
		super();
		this.userRepo = userRepo;
	}

	public String createUser(User user) {
		userRepo.save(user);
		System.out.println("User Save Successfully = " + user.toString());
		return user.toString();

	}

	public List<Notification> getNotification(Integer userId) throws UserNotFoundException {

		if (!userRepo.findById(userId).isPresent()) {
			throw new UserNotFoundException("User not found, No notification...");

		}

		return userRepo.findById(userId).get().getNotifications();
	}

}
