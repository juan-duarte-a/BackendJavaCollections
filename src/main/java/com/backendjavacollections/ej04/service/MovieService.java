package com.backendjavacollections.ej04.service;

import com.backendjavacollections.ej04.entity.Movie;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    
    private final Scanner sc;
    private final List<Movie> movies;

    public MovieService() {
        sc = new Scanner(System.in).useDelimiter("\n");
        movies = new ArrayList<>();
    }
    
    public void registerMovies() {
        boolean more;
        
        do {
            movies.add(createMovie());
            System.out.println("¿Desea registrar otra película? (S/N):");
            more = sc.next().equalsIgnoreCase("s");
        } while (more);
    }
    
    public Movie createMovie() {
        System.out.println("Ingresar título de la película:");
        String title = sc.next();
        System.out.println("Ingresar director:");
        String director = sc.next();
        System.out.println("Ingresar duración en horas:");
        double lengthHours = sc.nextDouble();
        Duration duration = Duration.ofMinutes((long) (lengthHours*60));
        
        return new Movie(title, director, duration);
    }
    
    public void listMovies() {
        movies.forEach(System.out::println);
    }
    
    public void orderByTitle() {
        System.out.println("\nPelículas ordenadas por título:");
        movies.sort(Comparator.comparing(Movie::getTitle));
        listMovies();
    }
    
    public void orderByDirector() {
        System.out.println("\nPelículas ordenadas por director:");
        movies.sort(Comparator.comparing(Movie::getDirector));
        listMovies();
    }
    
    public void orderByLength() {
        System.out.println("\nPelículas ordenadas por duración:");
        movies.sort(Comparator.comparing(Movie::getDuration));
        listMovies();
    }
    
    public void orderByLengthDescending() {
        System.out.println("\nPelículas ordenadas por duración descendente:");
        movies.sort(Comparator.comparing(Movie::getDuration).reversed());
        listMovies();
    }
    
    public void listMoviesLongerThanOneHour() {
        System.out.println("\nPelículas con duración mayor a una hora:");
        movies.stream().filter(m -> m.getDuration().compareTo(Duration.ofHours(1)) > 0)
                .forEach(System.out::println);
    }
    
}
