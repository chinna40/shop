package com.roche.shop.repository;

import com.roche.shop.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    /**
     * Method to return List of Products with same substring in name.
     * Does the same job as below method, but different way of doing in Spring
     * @param value Value to check
     * @return List of Product
     */
    List<Product> findByNameContaining(String value);

    /**
     * Method to return List of Products with same substring in name.
     * Does the same job as above method, but different way of doing in Spring
     * @param value Value to check
     * @return List of Product
     */
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:value%")
    List<Product> findByNameLike(@Param("value") String value);

}
