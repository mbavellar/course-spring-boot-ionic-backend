package com.mbavellar.coursesb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbavellar.coursesb.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
