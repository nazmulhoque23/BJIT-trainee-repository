package com.example.bjit.demoreactivetests;

import reactor.core.publisher.Flux;

public class InUpperAndReverse {
    public static void main(String[] args){
        String[] words = {"hello", "world", "there"};
        Flux.fromArray(words)
                .map(String::toUpperCase)
                .map(InUpperAndReverse::reversed)
                .subscribe(reverseString-> System.out.println(reverseString));


    }
    public static String reversed(String word){
        return new StringBuilder(word).reverse().toString();
    }
}
