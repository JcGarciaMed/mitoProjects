package com.example.apirest1.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.apirest1.entities.Order;
import com.example.apirest1.service.OrderService;
import com.example.apirest1.util.EntityDtoConverter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api
public class OrderController {
	
	@Autowired 
	private OrderService orderService;
	
	@Autowired
	private EntityDtoConverter converter;
	
	@ApiOperation(value = "Retorna listado de pedidos", notes = "Retorna LISTADOS DE PEDIDOS")
	@GetMapping("/orders")
	public ResponseEntity<List<OrderResponse>> findALL(){
		return new ResponseEntity<List<OrderResponse>>(converter.convertEntityToDto(orderService.findAllOrders()),HttpStatus.CREATED);
	}
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<OrderResponse> findById(@PathVariable String orderId){			
		return new ResponseEntity<OrderResponse>(converter.convertEntityToDto(orderService.findOrderById(orderId)),HttpStatus.OK);
	}
	

	@PostMapping("/orders")
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest payload){
		return new ResponseEntity<OrderResponse>(converter.convertEntityToDto(orderService.CreateOrder(payload)),HttpStatus.CREATED);
	}
	
}
