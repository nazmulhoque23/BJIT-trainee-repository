package com.bjit.hibernateexample.demohibernate;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ErrorHandling {
    public static void main(String[] args){
//        Flux.just(2,7,10)
//                .concatWith(Flux.error(new RuntimeException("Exception here!abort")))
//                .concatWith(Mono.just(5))
//                //.onErrorReturn(72)
////                .onErrorResume(err->{
////                    System.out.println("Error caught:"+err);
////                    return Mono.just(72);
////                })//will handle the exception
//                .map(element->{
//                    if(element ==7){
//                        throw new RuntimeException("ANOTHER EXCEPTION");
//                    }
//                    return element;
//                }).onErrorContinue((ex, el)->{
//                    System.out.println("Error caught:"+ex);
//                    System.out.println("Element that caused exception:"+el);
//                })
//                .log()
//                .subscribe();
//        Flux.just(15,10,12).map(el->{
//            if(el==10){
//                throw new RuntimeException("FATAL Exception");
//            }
//            return el;
//        }).onErrorMap(ex->{
//            System.out.println("error caught:"+ex);
//            return new Exception(ex.getMessage()+"this is a custom exception",ex);
//        }).log().subscribe();

//        Flux.just(15,10,20).concatWith(Flux.error(new RuntimeException("EXCEPTION!EXCEPTION!")))
//                .doOnError(ex-> System.out.println("Exception caught:"+ex))
//                .log()
//                .subscribe();

        Flux.fromArray(new String[]{"a","a","b","b","c"})
                .distinct(num->num)
                .subscribe(System.out::println);
    }
}
