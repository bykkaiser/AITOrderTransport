package com.examen.ait.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.ait.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, UUID>{
	Optional<Driver> findByActive(boolean active);
}
