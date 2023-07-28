package org.example;

public class ActionMovieBuilder extends MovieBuilder{
    public void buildLength(){
        movie.setLength("1 hour 56 Minutes");
    }
    public void buildName(){
        movie.setName("Avengers");
    }
    public void buildCategory(){
        movie.setCategory("PG-13");
    }
}
