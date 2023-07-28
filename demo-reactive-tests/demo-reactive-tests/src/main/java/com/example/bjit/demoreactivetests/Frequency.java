package com.example.bjit.demoreactivetests;

import org.antlr.v4.runtime.misc.Pair;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Frequency {
    public static void main(String[] args){
        Flux<String> words = Flux.fromArray(new String[]{"orange","banana","apple"});

        words.flatMap(word->Flux.fromArray(word.split("")))
                .groupBy(charValue->charValue)
                .flatMap(group->group.count().map(count-> Map.entry(group.key(),count)))
                .collectMap(Map.Entry::getKey, Map.Entry::getValue)//new Pair(group.key(),count))
                .subscribe(s-> System.out.println(s));


    }
}
