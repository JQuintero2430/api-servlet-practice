package com.jorge.practice.headers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Long id;
    private String name;
    private String type;
    private BigDecimal price;
}
