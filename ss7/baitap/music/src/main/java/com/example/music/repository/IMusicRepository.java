package com.example.music.repository;

import com.example.music.model.MusicDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository extends JpaRepository<MusicDTO, Integer> {
}