package com.example.apirest1.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest1.dto.OrderRequest;
import com.example.apirest1.dto.OrderResponse;


@RestController
public class OrderController {
	
	@GetMapping("/order")
	public ResponseEntity<List<OrderResponse>> findALL(){
		List<OrderResponse> order = new ArrayList<>();
		OrderResponse response = new OrderResponse();
		response.setAccountId("99988");
		response.setStatus("Pending");
		response.setOrderId("11222");
		response.setTotalAmount(10.0);
		response.setTotalTax(10.0);
		response.setTransactionDate(new Date());	
		
		OrderResponse response2 = new OrderResponse();
		response2.setAccountId("123");
		response2.setStatus("Pending");
		response2.setOrderId("1125522");
		response2.setTotalAmount(23.0);
		response2.setTotalTax(222.0);
		response2.setTransactionDate(new Date());
		
		order.add(response);
		order.add(response2);
		
		return new ResponseEntity<List<OrderResponse>>(order,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/order/{orderId}")
	public ResponseEntity<OrderResponse> findById(@PathVariable String orderId){
		
		OrderResponse response = new OrderResponse();
		response.setAccountId("99988");
		response.setStatus("Pending");
		response.setOrderId(orderId);
		response.setTotalAmount(10.0);
		response.setTotalTax(10.0);
		response.setTransactionDate(new Date());
		
		return new ResponseEntity<OrderResponse>(response,HttpStatus.OK);
	}
	

	@PostMapping("/order")
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest payload){
		OrderResponse response = new OrderResponse();
		response.setAccountId(payload.getAccountId());
		response.setStatus("Pending");
		response.setOrderId("116662");
		response.setTotalAmount(10.0);
		response.setTotalTax(10.0);
		response.setTransactionDate(new Date());	
		return new ResponseEntity<OrderResponse>(response,HttpStatus.CREATED);
	}
	
}
