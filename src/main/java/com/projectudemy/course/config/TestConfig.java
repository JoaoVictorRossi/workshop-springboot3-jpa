package com.projectudemy.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectudemy.course.entities.Order;
import com.projectudemy.course.entities.User;
import com.projectudemy.course.repositories.OrderRepository;
import com.projectudemy.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "joao", "joao@gmail.com", "9999", "12356");
		User u2 = new User(null, "Pedro", "pedro@gmail.com", "977777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2022-03-20T19:52:04Z"), u2);
		Order o2 = new Order(null, Instant.parse("2022-06-12T22:30:33Z"), u1);
		Order o3 = new Order(null, Instant.parse("2022-12-10T07:10:25Z"), u2);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
