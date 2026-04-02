package com.examen.ait.controller;

import java.util.Optional;
import java.util.UUID;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examen.ait.service.OrderService;
import com.examen.ait.dto.OrderDTO;
import com.examen.ait.entity.Driver;
import com.examen.ait.entity.Order;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;
	@PostMapping("/save")
	public ResponseEntity<OrderDTO> createOne(@RequestBody @Valid OrderDTO order) {
		OrderDTO primosB = orderService.createOne(order); 
		
		return ResponseEntity.status(HttpStatus.CREATED).body(primosB);
	}
	@GetMapping("/getOne")
	public ResponseEntity<Order> findActive(@PathVariable UUID id) {

		Optional<Order> driver = orderService.findOneById(id);

		if (driver.isPresent()) {
			return ResponseEntity.ok(driver.get());
		}

		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/changeStatus")
	public ResponseEntity<Boolean> updateOneById(@RequestBody OrderDTO order) {
		Boolean orderR = orderService.updateOneById(order);
		return ResponseEntity.ok(orderR);
	}
	
	@GetMapping("/getFilter")
	public ResponseEntity<List<Order>> getFilteredOrders(@RequestBody OrderDTO order) {

		List<Order> driver = orderService.getFilteredOrders(order.getStatus(),order.getDate(),order.getOrigin(),order.getDestination());

		if (!driver.isEmpty()) {
			return ResponseEntity.ok(driver);
		}

		return ResponseEntity.notFound().build();
	}

}
