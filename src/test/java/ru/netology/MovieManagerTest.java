package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    private Movie first = new Movie(1, "poster-bloodshot", "Bloodshot", "Action");
    private Movie second = new Movie(2, "poster-vpered", "Vpered", "Animation");
    private Movie third = new Movie(3, "poster-hotel-Belgrad", "Hotel Belgrad", "Comedy");
    private Movie fourth = new Movie(4, "poster-gentelmen", "Gentelmen", "Criminal comedy");
    private Movie fifth = new Movie(5, "poster-chelovek", "Chelovek-nevidimka", "Horror");
    private Movie sixth = new Movie(6, "poster-trolls", "Trolls 2", "Animation");
    private Movie seventh = new Movie(7, "poster-garry", "Garry Potter", "Fantasy");
    private Movie eighth = new Movie(8, "poster-avatar", "Avatar", "Fantasy");
    private Movie ninth = new Movie(9, "poster-home-alone", "Odin doma", "Comedy");
    private Movie tenth = new Movie(10, "poster-moana", "Moana", "Animation");
    private Movie eleventh = new Movie(11, "poster-paddington", "Paddington", "Comedy");
    private Movie twelfth = new Movie(12, "poster-shining", "Siyanie", "Horror");
    private Movie limit1 = new Movie(10);
    private Movie limit2 = new Movie(3);


    @Test
    public void shouldGetDownloadedMovies() {
        MovieManager manager = new MovieManager();
        manager.download(first);
        manager.download(second);
        manager.download(third);
        manager.download(fourth);
        manager.download(fifth);


        Movie[] actual = manager.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveByIDDownloadedMovies() {
        MovieManager manager = new MovieManager();
        manager.download(first);
        manager.download(second);
        manager.download(third);
        manager.download(fourth);
        manager.download(fifth);
        manager.download(sixth);
        manager.download(seventh);
        manager.download(eighth);
        manager.download(ninth);
        manager.download(tenth);
        manager.removeById(1);
        manager.removeById(3);
        manager.removeById(5);
        manager.removeById(7);
        manager.removeById(9);

        Movie[] actual = manager.findAll();
        Movie[] expected = new Movie[]{second, fourth, sixth, eighth, tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetDownloadedLastMoviesIfAmountIsBelowLimit() {
        MovieManager manager = new MovieManager();
        manager.download(first);
        manager.download(second);
        manager.download(third);
        manager.download(fourth);
        manager.download(fifth);
        manager.download(sixth);
        manager.download(seventh);
        manager.download(eighth);
        manager.download(ninth);
        manager.download(tenth);
        manager.download(eleventh);
        manager.download(twelfth);


        Movie[] actual = manager.lastMovies(limit1);
        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetDownloadedLastMoviesIfAmountIsUnderLimit() {
        MovieManager manager = new MovieManager();
        manager.download(first);
        manager.download(second);
        manager.download(third);
        manager.download(fourth);
        manager.download(fifth);



        Movie[] actual = manager.lastMovies(limit1);
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetDownloadedLastMoviesIfAmountIsBelowLimit2() {
        MovieManager manager = new MovieManager();
        manager.download(first);
        manager.download(second);
        manager.download(third);
        manager.download(fourth);
        manager.download(fifth);
        manager.download(sixth);
        manager.download(seventh);
        manager.download(eighth);
        manager.download(ninth);
        manager.download(tenth);
        manager.download(eleventh);
        manager.download(twelfth);


        Movie[] actual = manager.lastMovies(limit2);
        Movie[] expected = new Movie[]{twelfth, eleventh, tenth,};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetDownloadedLastMoviesIfAmountIsUnderLimit2() {
        MovieManager manager = new MovieManager();
        manager.download(first);
        manager.download(second);



        Movie[] actual = manager.lastMovies(limit2);
        Movie[] expected = new Movie[]{second, first};
        assertArrayEquals(expected, actual);
    }
}