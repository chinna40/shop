package com.roche.shop.controller;

import com.roche.shop.entity.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductController productController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllProducts() throws Exception {

        // given
        Product product = new Product();
        product.setId(1L);
        product.setName("Product 1");
        product.setPrice(1);

        List<Product> products = Arrays.asList(product);
        given(productController.getAll()).willReturn((ResponseEntity.ok(products)));
        // when + then
        this.mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':1,'productName':'Product 1','price':1,'createdAt':null,'updatedAt':null}]"));
    }

    @Test
    void saveProduct() {
    }

    @Test
    void getProductById() {
    }

    @Test
    void updateProductById() {
    }

    @Test
    void deleteProductById() {
    }
}