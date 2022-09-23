package com.example.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CarDetailDTO;
import com.example.dto.CustomerDetailDTO;
import com.example.entity.CarDetail;
import com.example.service.CarDetailService;
import com.example.service.CustomerDetailService;

@RestController
@CrossOrigin
public class CarController {
	@Autowired
	CarDetailService carService = null;

	@Autowired
	CustomerDetailService custService = null;

	// Inserting Car

	@PostMapping("/createCar")
	public CarDetailDTO createCar(@RequestBody CarDetailDTO dto) {
		CarDetail car = new CarDetail();
		car.setCarNo(dto.getCarNo());
		car.setCarMake(dto.getCarMake());
		car.setCarModel(dto.getCarModel());
		car.setCustomer(dto.getCustomer());
		CarDetail car1 = carService.insertCarDetail(car);
		dto.setCarId(car1.getCarId());
		dto.setCreatedAt(car1.getCreatedAt());
		dto.setUpdatedAt(car1.getUpdatedAt());
		return dto;
	}

	// Fetch Car By ID

	@PostMapping("/fetchCarById")
	public CarDetailDTO fetchCar(@RequestBody String carId) {
		CarDetail car = carService.findByCarId(new Long(carId));
		CarDetailDTO dto = new CarDetailDTO();
		dto.setCarId(car.getCarId());
		dto.setCarNo(car.getCarNo());
		dto.setCarMake(car.getCarMake());
		dto.setCarModel(car.getCarModel());
		dto.setCreatedAt(car.getCreatedAt());
		dto.setUpdatedAt(car.getUpdatedAt());
		dto.setCustomerId(car.getCustomer().getCustomerId());
		return dto;
	}

	// Fetch All Car
	@PostMapping("/fetchAllCar")
	public List<CarDetailDTO> fetchAllCar() {
		List<CarDetail> list = carService.fetchAllCar();
		CarDetailDTO dto = new CarDetailDTO();
		List<CarDetailDTO> list1 = new ArrayList<CarDetailDTO>();
		for (CarDetail d : list) {
			dto = new CarDetailDTO();
			dto.setCarId(d.getCarId());
			dto.setCarNo(d.getCarNo());
			dto.setCarMake(d.getCarMake());
			dto.setCarModel(d.getCarModel());
			dto.setCreatedAt(d.getCreatedAt());
			dto.setUpdatedAt(d.getUpdatedAt());
			dto.setCustomerId(d.getCustomer().getCustomerId());
			list1.add(dto);
		}
		return list1;
	}

}
