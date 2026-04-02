package com.examen.ait.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.ait.entity.OrderAssignments;

public interface OrderAssignmentsRepository extends JpaRepository<OrderAssignments, UUID>{

}
