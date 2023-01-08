package com.mbavellar.coursesb.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mbavellar.coursesb.domain.Category;
import com.mbavellar.coursesb.dto.CategoryDTO;
import com.mbavellar.coursesb.enums.OrderBy;
import com.mbavellar.coursesb.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

  @Autowired
  private CategoryService categoryService;
	
  @RequestMapping(value="/{id}", method = RequestMethod.GET)
  public ResponseEntity<Category> findById(@PathVariable Integer id) {
	  Category category = categoryService.findById(id);
	  return ResponseEntity.ok().body(category);
  }
  
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<CategoryDTO>> findAll() {
	  return ResponseEntity.ok().body(categoryService.findAll());
  }
  
  
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@RequestBody Category obj) {
	  obj.setId(null);
	  obj = categoryService.insert(obj);
	  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	  return ResponseEntity.created(uri).build();
  }
  
  @RequestMapping(value="/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> update(@RequestBody Category obj, @PathVariable Integer id) {
	  obj.setId(id);
	  obj = categoryService.update(obj);
	  return ResponseEntity.noContent().build();
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
	  categoryService.deleteById(id);
	  return ResponseEntity.noContent().build();
  }
  
  @RequestMapping(value = "/page", method = RequestMethod.GET)
  public ResponseEntity<Page<CategoryDTO>> findAllPaged(
		  @RequestParam(value = "page", defaultValue = "0") Integer page,
		  @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
		  @RequestParam(value = "direction", defaultValue = "ASC") Direction direction,
		  @RequestParam(value = "orderBy", defaultValue = "NAME") OrderBy orderBy) {
	  Page<CategoryDTO> pagedCategories = 
			  categoryService.findAllPaged(page, linesPerPage, orderBy, direction).map(obj -> new CategoryDTO(obj)); 

	  return ResponseEntity.ok().body(pagedCategories);
  }
  
  
}