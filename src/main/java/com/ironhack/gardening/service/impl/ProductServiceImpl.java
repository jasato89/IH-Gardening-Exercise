package com.ironhack.gardening.service.impl;

import com.ironhack.gardening.dto.ProductDTO;
import com.ironhack.gardening.model.Department;
import com.ironhack.gardening.model.Product;
import com.ironhack.gardening.repository.DepartmentRepository;
import com.ironhack.gardening.repository.ProductRepository;
import com.ironhack.gardening.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Product addProduct(ProductDTO product) {
        if (departmentRepository.findById(product.getDepartmentId()).isPresent()) {

            Department department = departmentRepository.findById(product.getDepartmentId()).get();
            Product product1 = new Product(product.getName(), product.getQuantity(), department);
            return productRepository.save(product1);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find the department provided");
        }
    }

    public Product decrementQuantity(int quantity, int productId) {
        if (!productRepository.findById(productId).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product doesn't exist");
        }
        Product product = productRepository.findById(productId).get();
        if (product.getQuantity() - quantity < 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "Quantity provided must be lower than current quantity");

        }
        product.setQuantity(product.getQuantity() - quantity);
        return productRepository.save(product);
    }

    public List<Product> showAllByDepartment(Optional<Integer> departmentId) {
        if (!departmentId.isPresent()) {
            return productRepository.findAll();
        } else {
            return productRepository.findByDepartmentId(departmentId.get());
        }

    }/*
        if (departmentRepository.findById(departmentId.get()).isPresent()) {
            Department department = departmentRepository.findById(departmentId.get()).get();
            return productRepository.findByDepartment(department);

            /*
            SELECT * FROM product;
            for (Product p : productRepository.findAll()) {
                if (p.getDepartment().equals(department)) {
                    products.add(p);
                }
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "Department doesn't exist");
        }
             */


    public Department addNewDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteProduct(int id) {
        if (!productRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "Product doesn't exist");
        }
        productRepository.deleteById(id);

    }

    @Override
    public void modifyQuantity(int id, Optional<String> name, Optional<Integer> quantity) {
        if (!productRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "Product doesn't exist");
        }
        Product product = productRepository.findById(id).get();
        if (name.isPresent()) {
            if (!name.isEmpty()) {
                product.setName(name.get());
            }
        }
        if (quantity.isPresent()) {
            if (quantity.get() > 0) {
                product.setQuantity(quantity.get());
            }
        }

        productRepository.save(product);

    }

    public void populateTable() {

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
