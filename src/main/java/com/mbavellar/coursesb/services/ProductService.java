package com.mbavellar.coursesb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbavellar.coursesb.domain.Client;
import com.mbavellar.coursesb.domain.Product;
import com.mbavellar.coursesb.repositories.ProductRepository;
import com.mbavellar.coursesb.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product findById(Integer id) {
		return productRepository.findById(id).orElseThrow(
				() -> new ObjectNotFoundException("Object NOT found! Id: " + id +
						", Tipo: " + Client.class.getName()));
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}
}
