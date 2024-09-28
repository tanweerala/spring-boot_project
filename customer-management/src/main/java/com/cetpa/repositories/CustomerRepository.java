package com.cetpa.repositories;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cetpa.entities.Customer;

@Repository
public class CustomerRepository 
{
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public CustomerRepository(SessionFactory factory)
	{
		session=factory.openSession();
		transaction=session.getTransaction();
	}
	public void saveRecord(Customer customer) 
	{
		transaction.begin();
		session.persist(customer);
		transaction.commit();
	}
	public List<Customer> getCustomerList() 
	{
		Query<Customer> query=session.createQuery("from Customer",Customer.class);
		List<Customer> customerList=query.list();
		return customerList;
	}
	public Customer getRecord(int cid) 
	{
		Customer cust=session.get(Customer.class,cid);
		return cust;
	}
	public void deleteRecord(Customer customer) 
	{
		transaction.begin();
		session.remove(customer);
		transaction.commit();
	}
	public void updateRecord(Customer ncustomer, Customer ocustomer) 
	{
		transaction.begin();
		ocustomer.setFirstname(ncustomer.getFirstname());
		ocustomer.setLastname(ncustomer.getLastname());
		ocustomer.setPhone(ncustomer.getPhone());
		ocustomer.setAddress(ncustomer.getAddress());
		ocustomer.setEmail(ncustomer.getEmail());
		transaction.commit();
	}
}
