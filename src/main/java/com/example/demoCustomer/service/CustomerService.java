package com.example.demoCustomer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demoCustomer.dto.CustomerDto;
import com.example.demoCustomer.repository.CustomerRepository;
import com.example.demoCustomer.utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;
	public Flux<CustomerDto> getCustomers(){
		return repository.findAll().map(AppUtils::entityToDto);
	}
	public Mono<CustomerDto> getCustomer(int id){
		return repository.findById(id).map(AppUtils::entityToDto);
	}
	
	public Mono<CustomerDto> saveCustomer(@RequestBody Mono<CustomerDto> customerDtoMono){
	    return customerDtoMono.map(AppUtils::dtoToEntity)
	             .flatMap(repository::save)
	             .map(AppUtils::entityToDto);
	    
		/*return customerDtoMono.map(AppUtils::dtoToEntity)
				.map(AppUtils::entityToDto);*/
	         
	}
	  
	public Mono<CustomerDto> updateCustomer(@RequestBody Mono<CustomerDto> customerDtoMono,int id){
	    return repository.findById(id)
	              .flatMap(p->customerDtoMono.map(AppUtils::dtoToEntity)
	              .doOnNext(e->e.setId(id)))
	              .flatMap(repository::save)
	              .map(AppUtils::entityToDto);
	}
	    
	public Mono<Void> deleteCustomer(int id){
	        return repository.deleteById(id);
	}
}
