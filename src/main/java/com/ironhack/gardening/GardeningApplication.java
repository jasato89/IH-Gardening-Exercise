package com.ironhack.gardening;

import com.ironhack.gardening.model.Department;
import com.ironhack.gardening.model.Product;
import com.ironhack.gardening.repository.DepartmentRepository;
import com.ironhack.gardening.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GardeningApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(GardeningApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Department department = new Department();
		Department department2 = new Department();
		Department department3 = new Department();

		department.setName("Tools");
		department2.setName("Flowers");
		department3.setName("Trees");

		departmentRepository.saveAll(List.of(department, department2, department3));

		Product product = new Product("Pala", 50, department);
		Product product2 = new Product("Flores de jardín", 70, department2);
		Product product3 = new Product("Pinos", 100, department3);

		productRepository.saveAll(List.of(product, product2, product3));


	}
}
