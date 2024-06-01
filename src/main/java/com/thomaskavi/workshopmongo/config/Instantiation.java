package com.thomaskavi.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.thomaskavi.workshopmongo.domain.Product;
import com.thomaskavi.workshopmongo.repository.ProductRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		productRepository.deleteAll();

		Product p1 = new Product(null, "Camisa", "Camisa gola V", "G", 3, 150.0);
		Product p2 = new Product(null, "Short", "Short curto alfaiataria", "M", 2, 250.0);
		Product p3 = new Product(null, "Macacão", "Macacão estampado em viscose", "M", 5, 300.0);
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
	}

}
