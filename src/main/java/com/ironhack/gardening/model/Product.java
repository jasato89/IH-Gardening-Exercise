package com.ironhack.gardening.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name must be defined")
    private String name;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Product(String name, int quantity, Department department) {
        this.name = name;
        this.quantity = quantity;
        this.department = department;
    }
}

// Product product = new Product();
// product.setId(id);
//product.setName(name);
//product.setQuantity(quantity);
//productRepository.save(product);
