package com.roche.shop.controller;

import com.roche.shop.entity.Product;
import com.roche.shop.entity.ProductDTO;
import com.roche.shop.entity.ProductMapper;
import com.roche.shop.exception.ProductNotFoundException;
import com.roche.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;

/**
 * Product Rest Controller.
 */
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value="/products")
    List<Product> getAll(){
        return productService.getAllProducts();
    }

    @GetMapping(value="/products/{id}")
    ResponseEntity<Product> getById(@PathVariable("id") @Min(1) int id) {

        Product prd = productService.findById(id)
                .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));

        return ResponseEntity.ok().body(prd);
    }

    @PostMapping(value="/products")
    ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO inprod) {
        Product prd      = ProductMapper.DtoToEntity(inprod);
        Product addedprd = productService.save(prd);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedprd.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/products/{id}")
    ResponseEntity<Product> updateProduct(@PathVariable("id")  @Min(1) int id, @Valid @RequestBody ProductDTO inprod) {

        Product prd = productService.findById(id)
                .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));

        Product newprd = ProductMapper.DtoToEntity(inprod);
        newprd.setId(prd.getId());
        productService.save(newprd);
        return ResponseEntity.ok().body(newprd);
    }

    @DeleteMapping(value="/products/{id}")
    ResponseEntity<String> deleteProduct( @PathVariable("id") @Min(1) int id) {
        Product prd = productService.findById(id)
                .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));

        productService.delete(prd.getId());
        return ResponseEntity.ok().body("Product with ID : "+id+" deleted with success!");

    }
}
