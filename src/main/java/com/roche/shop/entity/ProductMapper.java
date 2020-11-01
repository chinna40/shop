package com.roche.shop.entity;

public class ProductMapper {

    public static Product DtoToEntity(ProductDTO prd) {
        return new Product().setName(prd.getName())
                .setPrice(prd.getPrice());
    }

    public static ProductDTO EntityToDto(Product prd) {
        return new ProductDTO().setName(prd.getName())
                .setPrice(prd.getPrice());
    }
}
