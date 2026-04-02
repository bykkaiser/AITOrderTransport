package com.examen.ait.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class OrderAssignmentsDTO implements Serializable {
	
	@NotBlank(message = "El id no puede estar vacío")
    private UUID id;
	
	@NotBlank(message = "El id de la orden no puede estar vacío")
    private UUID ordId;
	
	@NotBlank(message = "El id del conductor no puede estar vacío")
    private UUID driverId;
	
	@NotBlank(message = "El pdf no puede estar vacío")
    private byte[] pdf;
	
	@NotBlank(message = "La imagen no puede estar vacío")
    private byte[] img;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getOrdId() {
		return ordId;
	}

	public void setOrdId(UUID ordId) {
		this.ordId = ordId;
	}

	public UUID getDriverId() {
		return driverId;
	}

	public void setDriverId(UUID driverId) {
		this.driverId = driverId;
	}

	public byte[] getPdf() {
		return pdf;
	}

	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "OrderAssignmentsDTO [id=" + id + ", ordId=" + ordId + ", driverId=" + driverId + ", pdf="
				+ Arrays.toString(pdf) + ", img=" + Arrays.toString(img) + "]";
	}

}
