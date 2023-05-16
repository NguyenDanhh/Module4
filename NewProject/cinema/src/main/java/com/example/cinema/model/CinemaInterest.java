package com.example.cinema.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CinemaInterest {

    @Id
    private String id ;

    @Column(name = "date")
    private String date;

    @Column(name = "count")
    private String count;

    @ManyToOne
    @JoinColumn(name = "id_movie")
    private Movie movie;

    public CinemaInterest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
