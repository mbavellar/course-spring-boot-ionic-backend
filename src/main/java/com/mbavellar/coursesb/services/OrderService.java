package com.mbavellar.coursesb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbavellar.coursesb.domain.Client;
import com.mbavellar.coursesb.domain.Order;
import com.mbavellar.coursesb.repositories.OrderRepository;
import com.mbavellar.coursesb.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {

	
	@Autowired
	OrderRepository orderRepository;
	
	public Order findById(Integer id) {
		return orderRepository.findById(id).orElseThrow(
				() -> new ObjectNotFoundException("Object NOT found! Id: " + id +
						", Tipo: " + Client.class.getName()));
	}
}
