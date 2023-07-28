package com.example.bjit.demoreactivetests;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Rotate {
    public static void main(String[] args){
        Integer[] items = {1,2,3,4,5,6};
        int rotateBy = 3;

        Flux.fromArray(items)
                .concatWithValues(Arrays.copyOfRange(items, 0, rotateBy))
                .skip(rotateBy)
                .subscribe(System.out::println);
    }
}
