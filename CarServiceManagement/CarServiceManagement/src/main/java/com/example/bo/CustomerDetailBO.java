package com.example.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.dao.CustomerRepository;
import com.example.entity.CustomerDetail;

@Component
public class CustomerDetailBO {
	@Autowired
	CustomerRepository custRep;

	public CustomerDetail insertCustomer(CustomerDetail cust) {
		return custRep.save(cust);
	}

	public CustomerDetail findCustomerById(Long customerId1) {
		return custRep.findCustomerById(customerId1);
	}

	public List<CustomerDetail> fetchAllCustomer() {
		return custRep.fetchAllCustomer();
	}
	
	public CustomerDetail updateCustomer(CustomerDetail cust) {
		return custRep.save(cust);
	}
	public void deleteCustomer(Long customerId) {
		custRep.deleteById(customerId);
	}
}
