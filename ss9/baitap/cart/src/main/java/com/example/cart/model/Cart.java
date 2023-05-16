package com.example.cart.model;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer , Integer> products = new HashMap<>();

    public Cart(Map<Integer, Integer> products) {
        this.products = products;
    }

    public Cart() {
    }

    public Map<Integer , Integer> getSelectedProducts(){
        return products;
    }
}
