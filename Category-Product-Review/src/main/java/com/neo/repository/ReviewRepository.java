package com.neo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neo.entity.Review;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
