package com.example.apirest1.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.apirest1.util.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "order_id")
	private String orderId;
	
	@Column(name="order_status")
	@Enumerated(value=EnumType.STRING)
	private OrderStatus status;
	
	@Column(name = "order_account_id")
	private String accountId;
	
	@Column(name = "order_total_amount")
	private Double totalAmount;
	
	@Column(name = "order_total_tax")
	private Double totalTax;
	
	@Column(name = "order_total_Amount_tax")
	private Double totalAmountTax;
	
	@Column(name = "order_transaction_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "order")
	private List<OrderDetail> items;
}
