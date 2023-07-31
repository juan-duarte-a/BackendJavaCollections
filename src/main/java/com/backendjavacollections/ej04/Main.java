package com.backendjavacollections.ej04;

import com.backendjavacollections.ej04.service.MovieService;

public class Main {
    
    public static void main(String[] args) {
        MovieService movieService = new MovieService();
        movieService.registerMovies();
        movieService.listMovies();
        movieService.orderByTitle();
        movieService.orderByDirector();
        movieService.orderByLength();
        movieService.orderByLengthDescending();
        movieService.listMoviesLongerThanOneHour();
    }
    
}
