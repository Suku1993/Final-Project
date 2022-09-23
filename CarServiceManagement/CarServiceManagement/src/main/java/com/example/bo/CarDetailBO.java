package com.example.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.CarRepository;
import com.example.entity.CarDetail;

@Component
public class CarDetailBO {
	@Autowired
	CarRepository carRep;

	public CarDetail insertCar(CarDetail car) {
		return carRep.save(car);
	}

	public CarDetail findByCarId(Long carId1) {
		return carRep.findCarById(carId1);
	}

	public List<CarDetail> fetchAllCar() {
		return carRep.fetchAllCar();
	}
}
