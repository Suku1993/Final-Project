package com.example.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.entity.CustomerDetail;

public class CarDetailDTO implements Serializable {
	private Long carId;
	private String carNo;
	private String carMake;
	private String carModel;
	private Date createdAt;
	private Date updatedAt;
	private Long customerId;
	CustomerDetail customer;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public CustomerDetail getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetail customer) {
		this.customer = customer;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
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
		return "CarDetailDTO [carId=" + carId + ", carNo=" + carNo + ", carMake=" + carMake + ", carModel=" + carModel
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
