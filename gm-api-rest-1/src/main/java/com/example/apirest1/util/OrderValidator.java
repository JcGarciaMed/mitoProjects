package com.example.apirest1.util;

import com.example.apirest1.dto.OrderRequest;
import com.example.apirest1.exception.IncorrectOrderRequestException;

public class OrderValidator {
	public static boolean validateOrder(OrderRequest order) {
		if(order.getItems() == null || order.getItems().isEmpty()) {
			throw new IncorrectOrderRequestException(ExceptionMessageEnum.INCORRECT_REQUEST_EMPTY_ITEMS_ORDER.getValue());
		}
		return true;
	}
}
