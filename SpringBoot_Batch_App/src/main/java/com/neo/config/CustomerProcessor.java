package com.neo.config;

import org.springframework.batch.item.ItemProcessor;

import com.neo.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Override
	public Customer process(Customer item) throws Exception {

		// logic

		return item;
	}

}
