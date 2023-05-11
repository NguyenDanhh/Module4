package com.example.validateexercise.repository;

import com.example.validateexercise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User , Integer> {
}
