package com.neo.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Serializable> {

}
