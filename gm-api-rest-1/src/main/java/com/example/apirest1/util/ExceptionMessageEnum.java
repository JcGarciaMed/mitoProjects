package com.example.apirest1.util;

public enum ExceptionMessageEnum {
	INCORRECT_REQUEST_EMPTY_ITEMS_ORDER("Pedido no tiene detalle");
	private String value;
	
	ExceptionMessageEnum(String message){
		this.value=message;
	}
	
	public String getValue() {
		return value;
	}
}
