package com.backendjavacollections.ej04.entity;

import java.time.Duration;

public class Movie {
    
    private String title;
    private String director;
    private Duration duration;

    public Movie(String title, String director, Duration duration) {
        this.title = title;
        this.director = director;
        this.duration = duration;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
    
    @Override
    public String toString() {
        return title + ". " + director + ". Duración: " 
                + (double) duration.toMinutes()/60.0 + " horas.";
    }
    
}
