package org.example;

public class ThrillerMovieBuilder extends MovieBuilder{
    public void buildLength(){
        movie.setLength("1 Hour 50 minutes");
    }
    public void buildName(){
        movie.setName("7even");
    }
    public void buildCategory(){
        movie.setCategory("R-Rated");
    }

}
