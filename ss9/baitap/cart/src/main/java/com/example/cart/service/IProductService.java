package com.example.cart.service;

import com.example.cart.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IProductService {
    List<Product> getListProduct();

    Product findById(Integer id);
}
