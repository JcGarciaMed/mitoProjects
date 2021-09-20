package com.example.apirest1.repositories;

import org.springframework.stereotype.Repository;

import com.example.apirest1.entities.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
		@Query("SELECT o FROM Order o WHERE o.accountId=?1")
		List<Order> listarPedidosPorCuenta(String accountId);
		
		@Query(value="SELECT * FROM orders o WHERE o.order_account_id=?1", nativeQuery= true)
		List<Order> listarPedidosPorCuentaSQL(String accountId);
		
		List<Order> findOrderByAccountId(String accountId);
		List<Order> findByAccountId(String accountId);
		Order findByOrderId(String orderId);		
}
