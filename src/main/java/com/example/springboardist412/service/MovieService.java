package com.example.springboardist412.service;

import com.example.springboardist412.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public MovieService() {
        // Add some dummy data
        movies.add(new Movie(1L, "Inception", "A sci-fi movie"));
        movies.add(new Movie(2L, "The Matrix", "Another sci-fi movie"));
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(Long id) {
        return movies.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addMovie(Movie movie) {
        long newId = movies.size() + 1L;
        movie.setId(newId);
        movies.add(movie);
    }
}
