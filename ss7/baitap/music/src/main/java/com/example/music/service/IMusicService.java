package com.example.music.service;

import com.example.music.model.MusicDTO;

import java.util.List;

public interface IMusicService {
    List<MusicDTO> findAll();
    MusicDTO findById(int id);
    void save(MusicDTO music);
}