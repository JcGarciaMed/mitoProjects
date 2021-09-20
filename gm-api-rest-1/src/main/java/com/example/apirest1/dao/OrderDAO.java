package com.example.apirest1.dao;

import java.util.List;
import java.util.Optional;

import com.example.apirest1.entities.Order;

public interface OrderDAO {
	List<Order> findAll();
	Optional<Order> findByOrderId(String orderId);
	Optional<Order> findById(Long id);
	Order save(Order order);	
}
