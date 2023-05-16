package com.example.cinema.Service;

import com.example.cinema.dto.CreateMovieDto;
import com.example.cinema.model.CinemaInterest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICenimaService {
    List<CinemaInterest> getAllCinemaInterest();

    void create(CinemaInterest movie);
}
