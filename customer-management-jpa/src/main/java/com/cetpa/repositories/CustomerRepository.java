package com.cetpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cetpa.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> 
{
}
