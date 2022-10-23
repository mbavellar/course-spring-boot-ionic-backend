package com.mbavellar.coursesb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbavellar.coursesb.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> { }
