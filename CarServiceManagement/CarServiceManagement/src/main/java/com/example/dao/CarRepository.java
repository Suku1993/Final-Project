package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.CarDetail;

@Repository
public interface CarRepository extends JpaRepository<CarDetail, Long> {
	// Fetch By ID
	@Query(value = "select c from CarDetail c where c.carId=:carId1")
	CarDetail findCarById(@Param("carId1") Long carId);

	// Fetch All
	@Query(value = "select c from CarDetail c")
	List<CarDetail> fetchAllCar();
}
