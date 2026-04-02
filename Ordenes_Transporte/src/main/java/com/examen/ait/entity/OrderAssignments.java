package com.examen.ait.entity;

import java.util.Arrays;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "order_assignments")
public class OrderAssignments {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;
	@NotBlank
	private UUID ord_id;
	@NotBlank
	private UUID driver_id;
	//@Lob
	private byte[] pdf;
	//@Lob
	private byte[] img;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getOrdId() {
		return ord_id;
	}
	public void setOrdId(UUID ordId) {
		this.ord_id = ordId;
	}
	public UUID getDriverId() {
		return driver_id;
	}
	public void setDriverId(UUID driverId) {
		this.driver_id = driverId;
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
		return "OrderAssignments [id=" + id + ", ordId=" + ord_id + ", driverId=" + driver_id + ", pdf="
				+ Arrays.toString(pdf) + ", img=" + Arrays.toString(img) + "]";
	}
	

}
