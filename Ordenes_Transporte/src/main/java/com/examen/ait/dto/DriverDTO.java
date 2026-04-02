package com.examen.ait.dto;
import java.io.Serializable;
import java.util.UUID;

import jakarta.validation.constraints.*;

public class DriverDTO implements Serializable {
	
	private UUID id;
	
	@NotBlank(message = "El nombre no puede estar vacío")
    private String name;
	
	@NotBlank(message = "El numero de licencia no puede estar vacío")
    private String licenseNumber;
	
	@NotNull(message = "El status no puede estar vacío")
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
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "DriverDTO [id=" + id + ", name=" + name + ", licenseNumber=" + licenseNumber + ", active=" + active
				+ "]";
	}
}
