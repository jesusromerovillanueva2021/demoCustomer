package com.example.demoCustomer.utils;

import org.springframework.beans.BeanUtils;

import com.example.demoCustomer.dto.CustomerDto;
import com.example.demoCustomer.entity.Customer;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

public class AppUtils {
	public static CustomerDto entityToDto(Customer customer) {
		CustomerDto customerDto=new CustomerDto();
		BeanUtils.copyProperties(customer, customerDto);
		return customerDto;
	}
	
	public static Customer dtoToEntity(CustomerDto customerDto) {
		Customer customer=new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		return customer;
	}
}
