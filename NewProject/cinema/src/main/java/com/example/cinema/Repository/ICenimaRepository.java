package com.example.cinema.Repository;

import com.example.cinema.model.CinemaInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICenimaRepository extends JpaRepository<Cre , String> {
}
