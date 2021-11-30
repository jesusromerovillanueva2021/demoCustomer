package com.example.demoCustomer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("customer")
public class Customer {
	@Id
	private int id;
	private String fullName;
	private String documentNumber;
	private CustomerType type;
	
	public enum CustomerType{
		Personal, Business
	}
}
