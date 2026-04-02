package com.examen.ait.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "driver")
public class Driver {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;
	@NotBlank
	private String name;
	@NotBlank
	private String license_number;
	@NotNull
	private Boolean active;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicenseNumber() {
		return license_number;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.license_number = licenseNumber;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", licenseNumber=" + license_number + ", active=" + active + "]";
	}
	
	

}
