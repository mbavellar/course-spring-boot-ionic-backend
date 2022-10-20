package com.mbavellar.coursesb.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbavellar.coursesb.domain.Category;
import com.mbavellar.coursesb.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

  @Autowired
  private CategoryService categoryService;
	
  @RequestMapping(value="/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> test(@PathVariable Integer id) {
	  Category category = categoryService.findById(id);
	  return ResponseEntity.ok().body(category);
  }
}
