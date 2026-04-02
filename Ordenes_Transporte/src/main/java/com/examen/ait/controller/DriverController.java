package com.examen.ait.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.ait.dto.DriverDTO;
import com.examen.ait.entity.Driver;
import com.examen.ait.service.DriverService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/driver")
public class DriverController {
	@Autowired
	DriverService driverService;

	@PostMapping("/save")
	public ResponseEntity<DriverDTO> createOne(@RequestBody @Valid DriverDTO driver) {
		DriverDTO driverR = driverService.createOne(driver);

		return ResponseEntity.status(HttpStatus.CREATED).body(driverR);
	}

	@GetMapping("/getActive")
	public ResponseEntity<Driver> findActive() {

		Optional<Driver> driver = driverService.findByActive(true);

		if (driver.isPresent()) {
			return ResponseEntity.ok(driver.get());
		}

		return ResponseEntity.notFound().build();
	}

}
