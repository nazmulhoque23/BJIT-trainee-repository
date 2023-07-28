package org.example;

public class Producer {
    private MovieBuilder movieBuilder;

    public void setMovieBuilder(MovieBuilder movieBuilder){
        this.movieBuilder = movieBuilder;
    }
    public Movie getMovie(){
        return movieBuilder.getMovie();
    }
    public void constructMovie(){
        movieBuilder.createNewMovie();
        movieBuilder.buildName();
        movieBuilder.buildCategory();
        movieBuilder.buildLength();

    }
}
