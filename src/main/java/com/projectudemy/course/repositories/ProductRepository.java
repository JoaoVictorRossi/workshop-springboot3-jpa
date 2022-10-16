package com.projectudemy.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectudemy.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
