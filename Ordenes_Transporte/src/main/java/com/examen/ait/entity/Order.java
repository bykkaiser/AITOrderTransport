package com.examen.ait.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.*;
import java.util.UUID;

@Entity
@Table(name = "\"order\"")

public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;
	@NotBlank
	private String status;
	@NotBlank
	private String origin;
	@NotBlank
	private String destination;
	@NotNull
	private OffsetTime created_at;
	@NotNull
	private OffsetTime updated_at;

	
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
	public OffsetTime getCreatedAt() {
		return created_at;
	}
	public void setCreatedAt(OffsetTime createdAt) {
		this.created_at = createdAt;
	}
	public OffsetTime getUpdatedAt() {
		return updated_at;
	}
	public void setUpdatedAt(OffsetTime updatedAt) {
		this.updated_at = updatedAt;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", origin=" + origin + ", destination=" + destination
				+ ", createdAt=" + created_at + ", updatedAt=" + updated_at + "]";
	}
}
