package com.roche.shop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ProductDTO {

    @NotBlank(message = "Name is required!")
    private String name;

    @NotNull
    @Min(value = 20)
    @Positive(message = "Price cannot be Zero or negative")
    private int price;
}
