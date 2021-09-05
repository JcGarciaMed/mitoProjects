package com.example.apirest1.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.apirest1.dto.OrderRequest;
import com.example.apirest1.dto.OrderResponse;
import com.example.apirest1.entities.Order;
import com.example.apirest1.util.OrderValidator;

@Service
public class OrderService {
	public Order CreateOrder(OrderRequest orderRequest) {
		OrderValidator.validateOrder(orderRequest);
		Order response = new Order();
		response.setAccountId(orderRequest.getAccountId());
		response.setStatus("Pending");
		response.setOrderId("116662");
		response.setTotalAmount(120.0);
		response.setTotalTax(308.26);
		response.setTransactionDate(new Date());
		return response;
	}
	
	public List<Order> findAllOrders(){
		List<Order> orders = new ArrayList<>();
		
		Order response = new Order();
		response.setAccountId("99988");
		response.setStatus("Pending");
		response.setOrderId("11222");
		response.setTotalAmount(10.0);
		response.setTotalTax(10.0);
		response.setTransactionDate(new Date());	
		
		Order response2 = new Order();
		response2.setAccountId("123");
		response2.setStatus("Pending");
		response2.setOrderId("1125522");
		response2.setTotalAmount(23.0);
		response2.setTotalTax(222.0);
		response2.setTransactionDate(new Date());
		
		orders.add(response);
		orders.add(response2);
		
		return orders;
	}
	
	public Order findOrderById(String orderId) {
		Order response = new Order();
		response.setAccountId("123456");
		response.setStatus("Pending");
		response.setOrderId(orderId);
		response.setTotalAmount(18.0);
		response.setTotalTax(1255.00);
		response.setTransactionDate(new Date());
		return response;
	}
}



