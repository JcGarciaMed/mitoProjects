package com.example.apirest1.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.apirest1.util.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="order_details")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "order_detail_quantity")
	private Integer quantity;
	
	@Column(name = "order_detail_price")
	private Double price;
	
	@Column(name = "order_detail_tax")
	private Double tax;
	
	@Column(name = "order_detail_upc")
	private String upc;	
	
	@Column(name = "order_detail_total_amount")
	private Double totalAmount;
	
	@ManyToOne
	private Order order;
	
}
