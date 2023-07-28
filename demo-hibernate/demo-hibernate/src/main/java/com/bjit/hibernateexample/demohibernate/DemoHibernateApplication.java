package com.bjit.hibernateexample.demohibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoHibernateApplication {

	public static void main(String[] args) {
//		Mono<String> monoString = Mono.just("data");
//		monoString.subscribe(data-> System.out.println(data), err-> System.out.println(err),()-> System.out.println("completed"));
		Mono<Object>monoException = Mono.fromSupplier(()->{
			throw new RuntimeException("exception");
		});
		monoException.subscribe(data-> System.out.println(data), err-> System.out.println(err),()-> System.out.println("completed"));

//		System.out.println("Flux fromStream()")
//		List<Integer> ints = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
//		Stream<Integer> intStreams = ints.stream();
//		Flux<Integer> fluxFromStream = Flux.fromStream(intStreams);
//
//		fluxFromStream.subscribe(data-> System.out.println(data));

		System.out.println("FLUX RANGE: ");
		Flux.range(1, 6).subscribe(System.out::println);
		//SpringApplication.run(DemoHibernateApplication.class, args);
	}

}
