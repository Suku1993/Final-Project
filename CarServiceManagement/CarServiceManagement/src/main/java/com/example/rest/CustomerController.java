package com.example.rest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.dto.CustomerDetailDTO;
import com.example.entity.CustomerDetail;
import com.example.service.CustomerDetailService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	@Autowired
	CustomerDetailService custService = null;

	// POST

	// Inserting Customer
	@PostMapping("/createCustomer")
	public CustomerDetailDTO creatCustomer(@RequestBody CustomerDetailDTO dto) {
		CustomerDetail e = new CustomerDetail();
		e.setCustomerName(dto.getCustomerName());
		e.setDateOfBirth(dto.getDateOfBirth());
		e.setMobileNo(dto.getMobileNo());
		e.setEmailId(dto.getEmailId());
		CustomerDetail e1 = custService.insertCustomerDetail(e);
		dto.setCustomerId(e1.getCustomerId());
		dto.setCreatedAt(e1.getCreatedAt());
		dto.setUpdatedAt(e1.getUpdatedAt());
		return dto;
	}

	// Update
	@PutMapping(value = "/updateCustomerDetail")
	public CustomerDetailDTO update(@RequestBody CustomerDetailDTO dto) {
		CustomerDetail e = new CustomerDetail();
		e.setCustomerId(dto.getCustomerId());
		e.setCustomerName(dto.getCustomerName());
		e.setDateOfBirth(dto.getDateOfBirth());
		e.setMobileNo(dto.getMobileNo());
		e.setEmailId(dto.getEmailId());
		custService.updateCustomer(e);
		return dto;
	}



	// Fetch Customer By ID
	@PostMapping("/fetchCustomerById")
	public CustomerDetailDTO fetchCustomer(@RequestBody String customerId) {
		CustomerDetail e = custService.findCustomerById(new Long(customerId));
		CustomerDetailDTO dto = new CustomerDetailDTO();
		dto.setCreatedAt(e.getCreatedAt());
		dto.setDateOfBirth(e.getDateOfBirth());
		dto.setCustomerId(e.getCustomerId());
		dto.setCustomerName(e.getCustomerName());
		dto.setEmailId(e.getEmailId());
		dto.setMobileNo(e.getMobileNo());
		dto.setUpdatedAt(e.getUpdatedAt());
		return dto;
	}

	// Fetch All
	@PostMapping(value = "/fetchAllCustomer")
	public List<CustomerDetailDTO> fetchCustomer() {
		List<CustomerDetail> list = custService.fetchAllCustomer();
		CustomerDetailDTO dto = new CustomerDetailDTO();
		List<CustomerDetailDTO> list1 = new ArrayList<CustomerDetailDTO>();
		for (CustomerDetail d : list) {
			dto = new CustomerDetailDTO();
			dto.setCreatedAt(d.getCreatedAt());
			dto.setDateOfBirth(d.getDateOfBirth());
			dto.setCustomerId(d.getCustomerId());
			dto.setCustomerName(d.getCustomerName());
			dto.setEmailId(d.getEmailId());
			dto.setMobileNo(d.getMobileNo());
			dto.setUpdatedAt(d.getUpdatedAt());
			list1.add(dto);
		}
		return list1;
	}
	
	// Delete
	@DeleteMapping(value = "/deleteCustomer/{customerId}")
	public void deleteCustomer(@PathVariable Long customerId) {
		custService.deleteCustomer(customerId);
	}

}
