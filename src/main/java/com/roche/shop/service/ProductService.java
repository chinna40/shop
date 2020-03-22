package com.roche.shop.service;

import com.roche.shop.entity.Product;

import java.util.List;

/**
 * Product Service.
 */
public interface ProductService {

    /**
     * Get All Products.
     * @return List of all products.
     */
    List<Product> getAllProducts();

    /**
     * Get Product By Id.
     * @param id Id
     * @return Product
     */
    Product getProductById(Long id);

    /**
     * Save Product.
     * @param product Product to save
     * @return Saved Product
     */
    Product saveProduct(Product product);

    /**
     * Update Product.
     * @param id Id
     * @param productToUpdate Product to Update
     * @return Updated Product
     */
    Product updateProductById(Long id, Product productToUpdate);

    /**
     * Delete Product by Id.
     * @param id Id
     */
    void deleteProductById(Long id);

    /**
     * Search Product by name containing.
     * @param searchString SearchString
     * @return Search result
     */
    List<Product> getProductByNameContaining(String searchString);

    /**
     * Search Product by name like.
     * @param searchString SearchString
     * @return Search result
     */
    List<Product> getProductByNameLike(String searchString);

}
