package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.dto.PostDto;
import com.neo.exception.PostNotFoundException;
import com.neo.exception.UserNotFoundException;
import com.neo.model.Post;
import com.neo.model.User;
import com.neo.repo.UserRepo;
import com.neo.service.PostService;



@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserRepo userRepo;
	
	
	@PostMapping("/createpost")
	public ResponseEntity<?> createPost(@RequestBody PostDto postDto) {
	    try {
	       
	        User user = userRepo.findById(postDto.getUserId())
	                            .orElseThrow(() -> new UserNotFoundException("User id = " + postDto.getUserId() + " not found"));

	       
	        Post post = new Post();
	        post.setContent(postDto.getContent());
	        post.setUser(user);

	   
	        String res = postService.createPost(post);
	        return new ResponseEntity<>(res, HttpStatus.CREATED);

	    } catch (UserNotFoundException e) {
	        return new ResponseEntity<>("User not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
	    } catch (Exception e) {
	        return new ResponseEntity<>("Other error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	
	@PutMapping("/likepost/{postid}")
	public ResponseEntity<?> doLike(@PathVariable("postid") Integer postId) throws PostNotFoundException{
		
		return new ResponseEntity<>(postService.likePost(postId), HttpStatus.CREATED);
	}

}
