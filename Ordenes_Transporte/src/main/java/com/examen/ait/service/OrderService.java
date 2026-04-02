package com.examen.ait.service;

import java.time.OffsetTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.examen.ait.entity.Order;
import com.examen.ait.dto.OrderDTO;

public interface OrderService {
	
	OrderDTO createOne(OrderDTO order);
	Optional<Order> findOneById(UUID orderId);
	Boolean updateOneById(OrderDTO order);
	List<Order> getFilteredOrders(String status, OffsetTime date, String origin, String destination);

}
