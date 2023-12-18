package com.jorge.practice.headers.sevices.impl;

import com.jorge.practice.headers.models.Product;
import com.jorge.practice.headers.sevices.IProductService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl implements IProductService {

    @Override
    public List<Product> findAll() {
        return Arrays.asList(new Product(1L, "Notebook", "Computing", new BigDecimal("1500.00")),
                new Product(2L, "Desktop", "Office", new BigDecimal("145.00")),
                new Product(3L, "Mechanic Keyboard", "Computing", new BigDecimal("130.00")),
                new Product(4L, "Mouse", "Computing", new BigDecimal("20.00")),
                new Product(5L, "Monitor", "Computing", new BigDecimal("200.00")));
    }
}
