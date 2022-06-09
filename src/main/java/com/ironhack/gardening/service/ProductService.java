package com.ironhack.gardening.service;

import com.ironhack.gardening.dto.ProductDTO;
import com.ironhack.gardening.model.Department;
import com.ironhack.gardening.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product addProduct(ProductDTO product);
    Product decrementQuantity(int quantity, int productId);
    List<Product> showAllByDepartment(Optional<Integer> departmentId);
    Department addNewDepartment(Department department);
    void deleteProduct(int id);

    void modifyQuantity(int id, Optional<String> name, Optional<Integer> quantity);
    void populateTable();

}
