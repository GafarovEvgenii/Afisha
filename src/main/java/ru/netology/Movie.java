package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Movie {
    private int id;
    private String image;
    private String name;
    private String genre;
    private int amountMovies;

    public Movie(int id, String image, String name, String genre) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.genre = genre;
    }

    public Movie(int amountMovies) {
        this.amountMovies = amountMovies;
    }
}




