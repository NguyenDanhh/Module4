package com.example.cart.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "name_product")
    private String name;
    @Column(name = "detail_product")
    private String detail;
    @Column(name = "price_product")
    private String price;

    @Column(name = "image_product")
    private String path;
    public Product() {
    }

    public Product(int id, String name, String detail, String price , String path) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
