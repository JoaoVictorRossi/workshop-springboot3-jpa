package com.projectudemy.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectudemy.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
