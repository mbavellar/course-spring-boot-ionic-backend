package com.mbavellar.coursesb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbavellar.coursesb.domain.Category;
import com.mbavellar.coursesb.repositories.CategoryRepository;
import com.mbavellar.coursesb.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository; 
	public Category findById(Integer id) {
		return categoryRepository.findById(id).orElseThrow(
			() -> new ObjectNotFoundException("Object not found! Id: " + id + 
					", Tipo: " + Category.class.getName()));
	}
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category insert(Category obj) {
		if (obj != null && obj.getId() == null)
			return categoryRepository.save(obj);
		throw new IllegalArgumentException("ID must be null for insertions!");
	}
}
