package com.roche.shop.service;

import com.roche.shop.entity.Product;
import com.roche.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Product Service Implementation.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product prd) {
        return productRepository.save(prd);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }


}
