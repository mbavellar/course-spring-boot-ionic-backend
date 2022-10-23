package com.mbavellar.coursesb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbavellar.coursesb.domain.Category;
import com.mbavellar.coursesb.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository; 
	public Category findById(Integer id) {
		return categoryRepository.findById(id).orElse(null);
	}
	public Object findAll() {
		return categoryRepository.findAll();
	}
}
