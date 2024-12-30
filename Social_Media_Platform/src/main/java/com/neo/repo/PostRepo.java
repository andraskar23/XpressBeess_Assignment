package com.neo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neo.model.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

}
