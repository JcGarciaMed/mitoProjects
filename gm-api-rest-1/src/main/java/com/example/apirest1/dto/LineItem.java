package com.example.apirest1.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(description = "Representa los items de un pedido")
public class LineItem {
	
	@ApiModelProperty(notes="UPC (UNIVERSAL PRODUCT CODE)", example = "1252548828772", required = true)
	private String upc;
	private int quantity;
	private double price;
}
