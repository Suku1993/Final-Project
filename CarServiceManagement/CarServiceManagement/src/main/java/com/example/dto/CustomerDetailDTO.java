package com.example.dto;

import java.io.Serializable;
import java.util.Date;

public class CustomerDetailDTO implements Serializable {
	private Long customerId;
	private String customerName;
	private Date dateOfBirth;
	private Long mobileNo;
	private String emailId;
	private Date createdAt;
	private Date updatedAt;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "CustomerDetailDTO [customerId=" + customerId + ", customerName=" + customerName + ", dateOfBirth="
				+ dateOfBirth + ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}


}
