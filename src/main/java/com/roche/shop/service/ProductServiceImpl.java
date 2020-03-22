package com.roche.shop.service;

import com.roche.shop.entity.Product;
import com.roche.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Plane Service Implementation.
 */
@Service
public class ProductServiceImpl implements ProductService {

    /**
     * Autowiring the Product Repository.
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * Get All Products.
     * @return List of all products.
     */
    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    /**
     * Get Product By Id.
     * @param id Id
     * @return Product
     */
    @Override
    public Product getProductById(final Long id) {
        return productRepository.findById(id).get();
    }

    /**
     * Save Product.
     * @param product Product to save
     * @return Saved Product
     */
    @Override
    public Product saveProduct(final Product product) {
        return productRepository.save(product);
    }

    /**
     * Update Product.
     * @param id Id
     * @param productToUpdate Product to Update
     * @return Updated Product
     */
    @Override
    public Product updateProductById(
            final Long id, final Product productToUpdate) {
        // Fetch the Product from db
        Product productFromDb = productRepository.findById(id).get();
        productFromDb.setName(productToUpdate.getName());
        return productRepository.save(productFromDb);
    }

    /**
     * Delete Product by Id.
     * @param id Id
     */
    @Override
    public void deleteProductById(final Long id) {
        productRepository.deleteById(id);
    }

    /**
     * Search Product by name containing.
     * @param searchString SearchString
     * @return Search result
     */
    @Override
    public List<Product> getProductByNameContaining(final String searchString) {
        return productRepository.findByNameContaining(searchString);
    }

    /**
     * Search Product by name like.
     * @param searchString SearchString
     * @return Search result
     */
    @Override
    public List<Product> getProductByNameLike(final String searchString) {
        return productRepository.findByNameLike(searchString);
    }

}
