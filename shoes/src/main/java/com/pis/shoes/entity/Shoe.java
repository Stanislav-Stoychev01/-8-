package com.pis.shoes.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shoe {

    @NotEmpty
    @Size(min = 1, max = 10)
    private String brand;

    private String model;

    private Colour colour;

    private Double price;

    private Integer size;

}
