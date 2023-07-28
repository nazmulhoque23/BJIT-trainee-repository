package com.bjit.hibernateexample.demohibernate;

import org.springframework.data.util.Pair;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

public class Conversion {
    public static void main(String[] args){
//        Flux<String> fluxExample = Flux.just("data", "data1", "data2");
//        Mono<String> nextValue = fluxExample.next();
//
//        Mono<String> data2 = Mono.just("data2");
//        Flux<String> monoToFlux = Flux.from(data2);

//        System.out.println("OPERATOR OPERATIONS");
//        Flux.fromArray(new String[]{"first", "second", "third"})
//                .filter(name->name.contains("f")).map(String::toUpperCase).subscribe(System.out::println);

//        Flux.fromArray(new String[]{"first", "second", "third"})
//                .groupBy(s->s.charAt(0))
//                //.flatMap(s->s.count())
//                //.flatMap(Conversion::stringMono)
//                .subscribe(group->{
//                    System.out.println("KEY:"+group.key());
//                    group.subscribe(element-> System.out.println("ELEMENT:"+element));
//                });
        Integer[] numbers = {1,2,3,4,5,5,5,6,7};
        Flux.fromArray(numbers)
                .collectMultimap(key -> key%2, key->key)
                .flatMapIterable(Map::values)
                .subscribe(value -> {
                    System.out.println("Duplicates: " + value);
                });

    }

    private static Mono<String> stringMono(String value){
        return Mono.just(value.concat(":updated"));
    }
}
