package com.example.cinema.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    @Column(name = "name_movie")
    private String nameMovie;

    @OneToMany(mappedBy = "movie")
    private List<CinemaInterest> list;

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public List<CinemaInterest> getList() {
        return list;
    }

    public void setList(List<CinemaInterest> list) {
        this.list = list;
    }
}
