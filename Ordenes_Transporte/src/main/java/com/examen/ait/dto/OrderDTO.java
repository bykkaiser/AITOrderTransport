package com.examen.ait.dto;

import java.io.Serializable;
import java.time.OffsetTime;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class OrderDTO implements Serializable {

	private UUID id;

	@NotBlank(message = "El status no puede estar vacío")
	private String status;
	
	@NotBlank(message = "El origen no puede estar vacío")
	private String origin;
	
	@NotBlank(message = "El destino no puede estar vacío")
	private String destination;
	
	private OffsetTime date;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public OffsetTime getDate() {
		return date;
	}

	public void setDate(OffsetTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", status=" + status + ", origin=" + origin + ", destination=" + destination
				+ "]";
	}

}
