package com.example.bai1.repository;

import com.example.bai1.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBlogRepository extends JpaRepository<Blog , Integer> {
    @Query(value = "SELECT * FROM blogs join category on blogs.category_id = category.id where name_category = ?",nativeQuery = true)
    List<Blog> findByName(String nameCategory);
}
