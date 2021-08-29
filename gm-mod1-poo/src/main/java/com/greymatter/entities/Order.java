package com.greymatter.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.greymatter.entities.enums.OrderStatus;


public class Order {
	private LocalDate moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	public Order() {
		super();		
	}
	
	public Order(LocalDate moment, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDate getMoment() {
		return moment;
	}

	public void setMoment(LocalDate moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum=0.0;
		for (OrderItem orderItem : items) {
			sum+=orderItem.subTotal();			
		}
		return sum;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("Order Moment:");
		sb.append(moment + "\n");
		sb.append("Order Status:");
		sb.append(status + "\n");
		sb.append("Client:");
		sb.append(client + "\n");
		sb.append("Order Items:");
		for (OrderItem orderItem : items) {
			sb.append(orderItem + "\n");
		}
		sb.append("TOTAL:");
		sb.append(total());
		return sb.toString();
	}

}
