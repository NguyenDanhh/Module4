package com.example.cinema.Service.impl;

import com.example.cinema.Repository.ICenimaRepository;
import com.example.cinema.Service.ICenimaService;
import com.example.cinema.dto.CreateMovieDto;
import com.example.cinema.model.CinemaInterest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenimaService implements ICenimaService {

    @Autowired
    private ICenimaRepository cenimaRepository;
    @Override
    public List<CinemaInterest> getAllCinemaInterest() {
        return cenimaRepository.findAll();
    }

    @Override
    public void create(CinemaInterest movie) {
        cenimaRepository.save(movie);
    }
}
