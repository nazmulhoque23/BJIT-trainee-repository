package org.example;

public class Main {
    public static void main(String[] args) {
        Producer producer = new Producer();
        MovieBuilder thrillerMovie = new ThrillerMovieBuilder();
        MovieBuilder actionMovie = new ActionMovieBuilder();

        producer.setMovieBuilder(thrillerMovie);
        producer.constructMovie();
        Movie movie = producer.getMovie();
        System.out.println(movie.toString()+" and this is a thriller movie");

        producer.setMovieBuilder(actionMovie);
        producer.constructMovie();
        Movie movie1 = producer.getMovie();
        System.out.println(movie1.toString()+" and this is a action movie");

    }
}