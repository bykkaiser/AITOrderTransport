package com.examen.ait.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.ait.dto.DriverDTO;
import com.examen.ait.entity.Driver;
import com.examen.ait.repository.DriverRepository;
import com.examen.ait.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
	@Autowired
	DriverRepository driverRepository;
	@Override
	public DriverDTO createOne(DriverDTO driver) {
		
		Driver driverR = new Driver();
		driverR.setName(driver.getName());
		driverR.setLicenseNumber(driver.getLicenseNumber());
		driverR.setActive(driver.getActive());
		driverRepository.save(driverR);
		return driver;
	}
	@Override
	public Optional<Driver> findByActive(boolean active) {
		
		return driverRepository.findByActive(active);
	}
}
