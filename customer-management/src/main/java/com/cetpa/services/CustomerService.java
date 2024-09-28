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
		customerRepository.saveRecord(customer);
	}

	public List<Customer> getList() 
	{
		return customerRepository.getCustomerList();
	}

	public Customer getCustomer(int cid) 
	{
		return customerRepository.getRecord(cid);
	}

	public void deleteCustomer(int cid) 
	{
		Customer customer=customerRepository.getRecord(cid);
		customerRepository.deleteRecord(customer);
	}

	public void updateCustomer(Customer ncustomer) 
	{
		Customer ocustomer=customerRepository.getRecord(ncustomer.getCid());
		customerRepository.updateRecord(ncustomer,ocustomer);	
	}
}
