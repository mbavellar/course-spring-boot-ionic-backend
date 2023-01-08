package com.mbavellar.coursesb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mbavellar.coursesb.domain.Category;
import com.mbavellar.coursesb.dto.CategoryDTO;
import com.mbavellar.coursesb.enums.OrderBy;
import com.mbavellar.coursesb.repositories.CategoryRepository;
import com.mbavellar.coursesb.services.exceptions.DataIntegrityException;
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
	public List<CategoryDTO> findAll() {
		return categoryRepository.findAll().stream().map(obj -> new CategoryDTO(obj)).toList();
	}
	
	public Category insert(Category obj) {
		if (obj != null && obj.getId() == null)
			return categoryRepository.save(obj);
		throw new IllegalArgumentException("ID must be null for insertions!");
	}
	public Category update(Category obj) {
		findById(obj.getId());
		return categoryRepository.save(obj);
	}
	public void deleteById(Integer id) {
		try {
		categoryRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cannot remove Category which has products!");
		}
	}
	
	public Page<Category> findAllPaged(Integer page, Integer linesPerPage, OrderBy orderBy, Direction direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, direction, orderBy.getValue());
		return categoryRepository.findAll(pageRequest);
	}
}
