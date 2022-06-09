package com.ironhack.gardening.repository;

import com.ironhack.gardening.model.Department;
import com.ironhack.gardening.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //SELECT * FROM Product WHERE departmentId = :departmentId;
    List<Product> findByDepartment(Department department);
    @Query(value = "SELECT * FROM product WHERE department_id = :departmentId", nativeQuery = true)
    List<Product>findByDepartmentId(int departmentId);
}
