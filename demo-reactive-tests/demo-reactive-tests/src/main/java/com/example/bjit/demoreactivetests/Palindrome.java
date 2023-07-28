package com.example.bjit.demoreactivetests;

import reactor.core.publisher.Flux;

public class Palindrome {
    public static void main(String[] args){
        String word = "radar";
        Flux.fromArray(word.split(""))
                .collect(StringBuilder::new, StringBuilder::append)
                .map(Palindrome::isPalindrome)
                .subscribe(isPalindrome->{
                    if(isPalindrome){
                        System.out.println("Palindrome");
                    }
                    else{
                        System.out.println("not a palindrome");
                    }
                });
    }
    public static Boolean isPalindrome(StringBuilder word){
        StringBuilder reversed = new StringBuilder(word).reverse();
        return word.toString().equals(reversed.toString());
    }
}
