package com.projectudemy.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectudemy.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
