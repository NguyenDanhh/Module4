package com.example.bai1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    private int id ;

    @Column(name = "name_category")
    private String nameCategory;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Blog> blogs;

    public Category() {
    }

    public Category(String nameCategory, List<Blog> blogs) {
        this.nameCategory = nameCategory;
        this.blogs = blogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String name_category) {
        this.nameCategory = name_category;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
