package com.example.apirest1.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.apirest1.entities.Order;

@Repository
public class OrderDaoImpl implements OrderDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Order> findAll() {
		return em.createQuery("SELECT o FROM Order o",Order.class).getResultList();
	}

	@Override
	public Optional<Order> findByOrderId(String orderId) {
		TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE o.orderId=:orderId",Order.class);
		query.setParameter("orderId", orderId);
		return Optional.ofNullable(query.getSingleResult());
	}

	@Override
	public Optional<Order> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(em.find(Order.class, id));
	}

	@Override
	public Order save(Order order) {
		em.persist(order);
		return order;
	}
	
}
