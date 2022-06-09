package com.ironhack.gardening.controller.impl;

import com.ironhack.gardening.controller.ProductController;
import com.ironhack.gardening.dto.ProductDTO;
import com.ironhack.gardening.dto.QuantityDTO;
import com.ironhack.gardening.model.Department;
import com.ironhack.gardening.model.Product;
import com.ironhack.gardening.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductControllerImpl implements ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/products/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody @Valid ProductDTO product) {
        return productService.addProduct(product);
    }
    @GetMapping("/products/{productId}/decrement")
    public Product decrementQuantity(@RequestParam int quantity, @PathVariable int productId) {
        return productService.decrementQuantity(quantity, productId);
    }

    @GetMapping("/products/by-department/")
    //localhost:8080/products/by-department/?departmentId=96
    public List<Product> showAllByDepartment(@RequestParam Optional<Integer> departmentId) {
        return productService.showAllByDepartment(departmentId);
    }

    @PostMapping("/departments/add")
    public Department addNewDepartment(@RequestBody Department department) {
        return productService.addNewDepartment(department);
    }
    @DeleteMapping("/products/{id}/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProduct(@PathVariable int id) {
         productService.deleteProduct(id);

    }

    @PostMapping("/products/{id}/modify-quantity")
    public void modifyQuantity(@PathVariable int id, @RequestParam Optional<String> name, Optional<Integer> quantity) {
        productService.modifyQuantity(id, name, quantity);

    }

    @GetMapping("/populate")
    public void populate() {
        productService.populateTable();
    }
}
