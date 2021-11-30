package com.example.demoCustomer.dto;

import com.example.demoCustomer.entity.Customer;
import com.example.demoCustomer.entity.Customer.CustomerType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	private int id;
	private String fullName;
	private String documentNumber;
	private CustomerType type;
}
