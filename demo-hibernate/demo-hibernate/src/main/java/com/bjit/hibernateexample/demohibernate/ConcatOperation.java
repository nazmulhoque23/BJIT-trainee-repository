package com.bjit.hibernateexample.demohibernate;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ConcatOperation {
    public static void main(String[] args){
//        Flux<String> flux1 = Flux.just("a","b","c");
//        Flux<String> flux2 = Flux.just("d","e","f");

//        Flux<String> concatValue = Flux.concat(flux2, flux1);
//        //concatValue.subscribe(System.out::println);
//
//        Mono<String> mono1 = Mono.just("g");
//        flux1.concatWith(mono1).subscribe(System.out::println);
//        Flux.zip(flux1,flux2,(f1, f2)->f1+f2).subscribe(System.out::println);

        //StepV
    }
    private static Flux<String> returnMerge(){
        Flux<String> flux1 = Flux.fromArray(new String[]{"a","b","c"}).delayElements(Duration.ofMillis(100));
        Flux<String> flux2 = Flux.fromArray(new String[]{"d","e","f"}).delayElements(Duration.ofMillis(120));
        return Flux.merge(flux1, flux2);
    }
}
