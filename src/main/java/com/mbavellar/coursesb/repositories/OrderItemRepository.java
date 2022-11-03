package com.mbavellar.coursesb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbavellar.coursesb.domain.OrderItem;
import com.mbavellar.coursesb.domain.OrderItemPK;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
