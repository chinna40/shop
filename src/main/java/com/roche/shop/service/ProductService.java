package com.roche.shop.service;

import com.roche.shop.entity.Product;

import java.util.List;
import java.util.Optional;

/**
 * Product Service.
 */
public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> findById(int id);
    Product save(Product prd);
    void delete(int id);
}
