package com.projectudemy.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projectudemy.course.entities.User;
import com.projectudemy.course.repositories.UserRepository;
import com.projectudemy.course.services.exceptions.DatabaseException;
import com.projectudemy.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User objUser) {
		return userRepository.save(objUser);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);	
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User user) {
		User entity = userRepository.getReferenceById(id);
		updateData(entity, user);
		return userRepository.save(entity);
	}
	
	private void updateData(User entity, User objUser) {
		entity.setName(objUser.getName());
		entity.setEmail(objUser.getEmail());
		entity.setPhone(objUser.getPhone());
	}
}
