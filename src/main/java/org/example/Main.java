package org.example;

import org.example.models.Genre;
import org.example.models.Movie;
import org.example.services.Service;


public class Main {
    public static void main(String[] args) {

        Service s = new Service(ObjectDBUtil.getEntityManagerFactory());

        Movie m = new Movie();
        m.setDirector("Antonio Perez");
        Genre g = new Genre();
        g.setGenre("Action");
        g = new Genre();
        g.setGenre("Romantic");
        m.getGenres().add(g);
        m.getGenres().add(g);
        m.setYear(2017);
        m.setTitle("The Action");

        s.save(m);

        s.getMovies().forEach(System.out::println);
        System.out.println(s.countMoviesByDirector("Antonio Perez"));

    }
}