package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bo.CustomerDetailBO;
import com.example.entity.CustomerDetail;

@Component
public class CustomerDetailService {
	@Autowired
	CustomerDetailBO bo;

	public CustomerDetail insertCustomerDetail(CustomerDetail cust) {
		return bo.insertCustomer(cust);
	}

	public CustomerDetail findCustomerById(Long CustId1) {
		return bo.findCustomerById(CustId1);
	}

	public List<CustomerDetail> fetchAllCustomer() {
		return bo.fetchAllCustomer();
	}
	
	public CustomerDetail updateCustomer(CustomerDetail cust) {
		return bo.updateCustomer(cust);
	}
	public void deleteCustomer(Long customerId) {
		bo.deleteCustomer(customerId);
	}

}
