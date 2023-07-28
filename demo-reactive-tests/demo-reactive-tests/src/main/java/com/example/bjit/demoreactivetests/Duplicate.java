package com.example.bjit.demoreactivetests;

import reactor.core.publisher.Flux;

import java.util.*;
import java.util.stream.Collector;

public class Duplicate {
    public static void main(String[] args){
        Integer[] numbers = {1,2,3,4,5,5,6,6,7};
        Flux.fromArray(numbers)
                .collectMultimap(key -> key)
                .flatMapIterable(Map::entrySet)
                .filter(collection -> collection.getValue().size() > 1)
                .subscribe(duplicates -> {
                    System.out.println("Duplicates: " + duplicates.getKey());
                });








//        Flux.fromArray(numbers)
//                .groupBy(number -> number)
//                .filter(group->group.count().block()>1)
//                .doOnNext(duplicateElements::add)
//                .subscribe(s-> System.out.println(s));
//                //.subscribe(duplicate -> System.out.println("Duplicate: " + duplicate.key()));
    }
}
