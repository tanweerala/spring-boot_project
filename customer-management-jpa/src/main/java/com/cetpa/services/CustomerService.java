package com.cetpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.Customer;
import com.cetpa.repositories.CustomerRepository;

@Service
public class CustomerService 
{
	@Autowired private CustomerRepository customerRepository;

	public void saveCustomer(Customer customer) 
	{
		customerRepository.save(customer);
	}

	public List<Customer> getList() 
	{
		return customerRepository.findAll();
	}

	public Customer getCustomer(int cid) 
	{
		return customerRepository.findById(cid).orElse(null);
	}

	public void deleteCustomer(int cid) 
	{
		customerRepository.deleteById(cid);
	}

	public void updateCustomer(Customer customer) 
	{
		customerRepository.save(customer);	
	}
}
