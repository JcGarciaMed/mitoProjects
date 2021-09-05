package com.example.apirest1.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.apirest1.dto.OrderResponse;
import com.example.apirest1.entities.Order;

@Component
public class EntityDtoConverter {
	
	@Autowired
	private ModelMapper mapper;
	
	public OrderResponse convertEntityToDto(Order order) {
		return mapper.map(order, OrderResponse.class);
	}
	
	public List<OrderResponse> convertEntityToDto(List<Order> orders) {
		return orders.stream()
					.map(order->convertEntityToDto(order))
					.collect(Collectors.toList());
	}
}
