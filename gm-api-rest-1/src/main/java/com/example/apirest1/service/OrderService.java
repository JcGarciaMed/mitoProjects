package com.example.apirest1.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest1.dao.OrderDAO;
import com.example.apirest1.dto.OrderRequest;
import com.example.apirest1.dto.OrderResponse;
import com.example.apirest1.entities.Order;
import com.example.apirest1.entities.OrderDetail;
import com.example.apirest1.exception.OrderNotFoundException;
import com.example.apirest1.repositories.OrderRepository;
import com.example.apirest1.util.Constants;
import com.example.apirest1.util.OrderStatus;
import com.example.apirest1.util.OrderValidator;
import java.util.Optional;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDAO orderDAO;
	
	public Order CreateOrder(OrderRequest orderRequest) {
		OrderValidator.validateOrder(orderRequest);
		Order newOrder = initOrder(orderRequest);
		return orderRepository.save(newOrder);
	}
	
	@Transactional
	public Order CreateOrderDAO(OrderRequest orderRequest) {
		OrderValidator.validateOrder(orderRequest);
		Order newOrder = initOrder(orderRequest);
		return orderDAO.save(newOrder);
	}	
	
	
	public List<Order> findOrdersByAccountId(String accountID){
		 Optional<List<Order>> orders = Optional.ofNullable(orderRepository.findOrderByAccountId(accountID));		
		 return orders.orElseThrow(()->new OrderNotFoundException("account ID no encontrado"));
	}
	
	public List<Order> findByAccountId(String accountID){
		 Optional<List<Order>> orders = Optional.ofNullable(orderRepository.findByAccountId(accountID));
		 return orders.orElseThrow(()->new OrderNotFoundException("account ID no encontrado"));
		/*List<Order> orders = orderRepository.findByAccountId(accountID);
		// if(orders.isEmpty() || orders == null) {
		//	 throw new OrderNotFoundException("account ID no encontrado");
		 }else {
			 return orders;
		 }*/		 
	}	
	
	public List<Order> findByAccountIdQuery(String accountID){
		 Optional<List<Order>> orders = Optional.ofNullable(orderRepository.listarPedidosPorCuenta(accountID));		
		 return orders.orElseThrow(()->new OrderNotFoundException("account ID No encontrado"));
	}		
	
	public List<Order> findByAccountIdSQL(String accountID){
		 Optional<List<Order>> orders = Optional.ofNullable(orderRepository.listarPedidosPorCuentaSQL(accountID));		
		 return orders.orElseThrow(()->new OrderNotFoundException("account ID No encontrado"));
	}		
	
	public List<Order> findAllOrders(){
		return orderRepository.findAll();
	}
	
	public List<Order> findAllOrdersDAO(){
		return orderDAO.findAll();
	}	
	
	public Order findOrderById(String orderId) {
		Optional<Order> order = Optional.ofNullable(orderRepository.findByOrderId(orderId));
		return order.orElseThrow(()-> new OrderNotFoundException("Order ID no encontrado"));
	}
	
	public Order findOrderByIdDAO(String orderId) {		
		return orderDAO.findByOrderId(orderId).orElseThrow(()->new OrderNotFoundException("Order ID no encontrado DAO"));
	}	
	
	private Order initOrder(OrderRequest orderRequest) {
		Order object = new Order();
		object.setOrderId(UUID.randomUUID().toString());
		object.setAccountId(orderRequest.getAccountId());
		object.setStatus(OrderStatus.PENDING);
		
		List<OrderDetail> items = orderRequest.getItems().stream()
														.map(item->OrderDetail.builder().price(item.getPrice())
																.quantity(item.getQuantity())
																.upc(item.getUpc())
																.tax((item.getPrice()*item.getQuantity()) * Constants.TAX_IMPORT)
																.totalAmount(item.getPrice()*item.getQuantity())
																.order(object).build())
														.collect(Collectors.toList());
		object.setItems(items);
		object.setTotalAmount(items.stream().mapToDouble(OrderDetail::getTotalAmount).sum());
		object.setTotalTax(object.getTotalAmount() * Constants.TAX_IMPORT);
		object.setTotalAmountTax(object.getTotalAmount() + object.getTotalTax());
		object.setTransactionDate(new Date());
		
		return object;
	}
}



