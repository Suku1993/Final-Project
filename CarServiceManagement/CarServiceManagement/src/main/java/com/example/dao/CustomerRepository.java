package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.entity.CustomerDetail;

public interface CustomerRepository extends JpaRepository<CustomerDetail, Long> {

	// Fetch By ID
	@Query(value = "select c from CustomerDetail c where c.customerId=:customerId1")
	CustomerDetail findCustomerById(@Param("customerId1") Long customerId);

	// Fetch All
	@Query(value = "select c from CustomerDetail c")
	List<CustomerDetail> fetchAllCustomer();
	
}
