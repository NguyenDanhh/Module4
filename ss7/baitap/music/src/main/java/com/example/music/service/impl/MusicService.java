package com.example.music.service.impl;

import com.example.music.model.MusicDTO;
import com.example.music.repository.IMusicRepository;
import com.example.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<MusicDTO> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public MusicDTO findById(int id) {
        return musicRepository.findById(id).get();
    }

    @Override
    public void save(MusicDTO music) {
        musicRepository.save(music);
    }
}