package com.example.apirest1.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class OrderRequest {
	private String accountId;
	private List<LineItem> items;
}
