package org.example;

abstract class MovieBuilder {
    protected Movie movie;

    public void createNewMovie(){
        movie = new Movie();
    }
    public Movie getMovie(){
        return movie;
    }
    public abstract void buildLength();
    public abstract void buildName();
    public abstract void buildCategory();
}
