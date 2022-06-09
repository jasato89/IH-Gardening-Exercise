package com.ironhack.gardening.controller;

import com.ironhack.gardening.dto.ProductDTO;
import com.ironhack.gardening.model.Department;
import com.ironhack.gardening.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductController {

    /*
    Create a route for adding new products (validate the payload format)
    Create a route for decrementing the quantity of a product by an amount specified in a parameter. Throw a custom error and respond with an appropriate response code if the specified amount is less than the quantity of the product in stock.
    Create a route to get all products by department. Return all products if the department param is empty/null.
    Create a route to get a product by id. Throw an error and respond with an appropriate response code if the id does not exist.
    Create a route to add a new department (validate the payload format)
    Create a DELETE route to delete products from the product list by id.
     */

    Product addProduct(ProductDTO product);
    Product decrementQuantity(int quantity, int productId);
    List<Product> showAllByDepartment(Optional<Integer> productId);
    Department addNewDepartment(Department department);
    void deleteProduct(int id);
}
