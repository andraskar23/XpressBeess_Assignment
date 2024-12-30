package com.neo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.exception.PostNotFoundException;

import com.neo.model.Notification;
import com.neo.model.Post;
import com.neo.model.User;
import com.neo.repo.PostRepo;
import com.neo.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PostRepo postRepo;

	public String createPost(Post post) {

		User user = post.getUser();
		user.getPosts().add(post);
		postRepo.save(post);

		return post.getContent()+"= Post created successfully";
	}

	public String likePost(Integer postId) throws PostNotFoundException {
		// TODO Auto-generated method stub
		Optional<Post> post = postRepo.findById(postId);
		if (!post.isPresent()) {
			throw new PostNotFoundException("cannot like, post not found...");
		}

		Post currPost = post.get();

		if(currPost.getLikes()== null) {
			currPost.setLikes(1);
		}else {
		currPost.setLikes(currPost.getLikes() + 1);
		}

		Optional<User> user = userRepo.findById(currPost.getUser().getUserId());
		User currUser = user.get();
		Notification notification = new Notification();
		notification.setPostId(postId);
		notification.setUser(currUser);
		currUser.getNotifications().add(notification);

		userRepo.save(currUser);
		return "Post liked...";

	}

}
