package com.examen.ait.serviceImpl;

import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.examen.ait.entity.Order;
import com.examen.ait.service.OrderService;
import com.examen.ait.repository.OrderRepository;
import com.examen.ait.dto.OrderDTO;
import com.examen.ait.utility.ManageStatus;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;

	@Override
	public OrderDTO createOne(OrderDTO order) {
		Order orderR = new Order();
		validateStatus(order.getStatus());
		orderR.setStatus(order.getStatus());
		orderR.setOrigin(order.getOrigin());
		orderR.setDestination(order.getDestination());
		OffsetTime ahora = OffsetTime.now();
		System.out.println(ahora);
		orderR.setCreatedAt(ahora);
		orderR.setUpdatedAt(ahora);
		orderRepository.save(orderR);
		return order;
	}

	@Override
	public Optional<Order> findOneById(UUID orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		return order;
	}

	@Override
	public Boolean updateOneById(OrderDTO order) {
		Order orderR = orderRepository.findById(order.getId())
				.orElseThrow(() -> new EntityNotFoundException("Orden no encontrada"));

		validateStatus(orderR.getStatus());

		if (!ManageStatus.validateChange(ManageStatus.valueOf(order.getStatus()))) {
			throw new IllegalStateException("Transición no permitida");
		}

		order.setStatus(order.getStatus());
		return true;
	}

	@Override
	public List<Order> getFilteredOrders(String status, OffsetTime date, String origin, String destination) {
		
		return orderRepository.findAll(withFilters(status, date, origin, destination));
	}

	public boolean isValid(String statusReceived) {
		if (statusReceived == null)
			return false;

		try {
			ManageStatus.valueOf(statusReceived.toUpperCase());
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public String validateStatus(String statusFromFront) {
		if (!isValid(statusFromFront)) {

			throw new RuntimeException("Error: El estado '" + statusFromFront + "' no es válido.");
		}
		return statusFromFront;
	}

	public static Specification<Order> withFilters(String status, OffsetTime date, String origin, String destination) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (status != null) {
				predicates.add(cb.equal(root.get("status"), status));
			}

			if (date != null) {
				predicates.add(cb.equal(root.get("createdAt").as(OffsetTime.class), date));
			}

			if (origin != null && !origin.isBlank()) {
				predicates.add(cb.like(cb.lower(root.get("origin")), "%" + origin.toLowerCase() + "%"));
			}

			if (destination != null && !destination.isBlank()) {
				predicates.add(cb.like(cb.lower(root.get("destination")), "%" + destination.toLowerCase() + "%"));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
