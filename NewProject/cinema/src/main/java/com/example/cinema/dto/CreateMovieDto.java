package com.example.cinema.dto;


import com.example.cinema.model.Movie;
import org.springframework.validation.Errors;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CreateMovieDto {

    @NotBlank
    @NotNull
    @Pattern(regexp = "^(CI)-[A-Z]{4}$" ,message = "Mời nhập đuúng định dạng CI-XXXX")
    private String id ;

    @NotNull
    @NotBlank
    private String date;

    @NotNull
    @NotBlank
    @Size(min = 1 , message = "số lượng vé phải lớn hoơn 0")
    private String count;

    @ManyToOne
    @JoinColumn(name = "id_movie")
    private Movie movie;

    public CreateMovieDto() {
    }

    public CreateMovieDto(String id, String date, String count, Movie movie) {
        this.id = id;
        this.date = date;
        this.count = count;
        this.movie = movie;
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

    public void checkDateNow(Object target, Errors errors){
//        CreateMovieDto movieDto = (CreateMovieDto) target;
//        LocalDate dateCinemaInterest = LocalDate.parse(movieDto.date);
//        LocalDate now = LocalDate.now();
//        if(dateCinemaInterest < now){
//            errors.rejectValue("da");
//        }
    }
}
