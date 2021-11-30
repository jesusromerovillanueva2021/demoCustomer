package com.example.demoCustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoCustomer.dto.CustomerDto;
import com.example.demoCustomer.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
    private CustomerService service;

    @GetMapping
    public Flux<CustomerDto> getCustomers(){
        return service.getCustomers();
    }

    @GetMapping("/{id}")
    public Mono<CustomerDto> getProduct(@PathVariable int id){
        return service.getCustomer(id);
    }

   
    @PostMapping
    public Mono<CustomerDto> saveCustomer(@RequestBody Mono<CustomerDto> customerDtoMono){
        return service.saveCustomer(customerDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<CustomerDto> updateProduct(@RequestBody Mono<CustomerDto> customerDtoMono,@PathVariable int id){
        return service.updateCustomer(customerDtoMono, id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteCustomer(@PathVariable int id){
        return service.deleteCustomer(id); 
    }
}
