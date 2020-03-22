package com.roche.shop.controller;

import com.roche.shop.entity.Product;
import com.roche.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Product Rest Controller.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    /**
     * Auto wiring the Product Service.
     */
    @Autowired
    private ProductService productService;


    /**
     * get Api to return list of all products.
     * @return List of products
     */
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    /**
     * Api to save new Product.
     * @param product Product to add
     * @return Saved Product
     */
    @PostMapping()
    public ResponseEntity<Product> saveProduct(
            @RequestBody final  Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }


    /**
     * get Api to return the Product by Id.
     * @param id Id
     * @return Products
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(
            @PathVariable("id") final Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * Api to update an existing Product.
     * @param id Id to update
     * @param productToUpdate Product to update
     * @return Updated Product
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProductById(
            @PathVariable("id") final Long id,
            @RequestBody final Product productToUpdate) {
        Product updatedProduct
                = productService.updateProductById(id, productToUpdate);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    /**
     * Api to delete a Product.
     * @param id Id to delete
     * @return Success Message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(
            @PathVariable("id") final Long id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
