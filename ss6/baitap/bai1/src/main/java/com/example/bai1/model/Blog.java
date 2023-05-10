package com.example.bai1.model;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    @Column(name = "name_blog")
    private String name ;

    @Column(name = "date_submit")
    private String date;

    @Column(name = "detail_blog")
    private String detail;

    @ManyToOne
    @JoinColumn(name = "id_category" , referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String name, String date, String detail, Category category) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.detail = detail;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
