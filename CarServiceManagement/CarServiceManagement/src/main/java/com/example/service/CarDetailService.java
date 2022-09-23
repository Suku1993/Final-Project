package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bo.CarDetailBO;
import com.example.entity.CarDetail;

@Component
public class CarDetailService {
	@Autowired
	CarDetailBO bo;

	public CarDetail insertCarDetail(CarDetail car) {
		return bo.insertCar(car);
	}

	public CarDetail findByCarId(Long carId1) {
		return bo.findByCarId(carId1);
	}

	public List<CarDetail> fetchAllCar() {
		return bo.fetchAllCar();
	}
}
