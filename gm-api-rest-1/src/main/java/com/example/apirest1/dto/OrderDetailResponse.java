package com.example.apirest1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailResponse {
	private Long id;
	private Integer quantity;
	private Double price;
	private Double tax;
	private String upc;
	private Double totalAmount;
}
