package com.examen.ait.service;

import java.util.List;
import java.util.Optional;

import com.examen.ait.dto.DriverDTO;
import com.examen.ait.entity.Driver;

public interface DriverService {

	DriverDTO createOne(DriverDTO driver);
	Optional<Driver> findByActive(boolean active);
}
