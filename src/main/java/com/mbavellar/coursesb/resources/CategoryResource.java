package com.mbavellar.coursesb.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbavellar.coursesb.domain.Category;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

  @RequestMapping(method = RequestMethod.GET)
  public List<Category> test() {
	  
	  Category cat1 = new Category(1, "IT");
	  Category cat2 = new Category(1, "Office");
	  
	  List<Category> categories = new ArrayList<>();
	  categories.add(cat1);
	  categories.add(cat2);
	  
	  return categories;
  }
}
