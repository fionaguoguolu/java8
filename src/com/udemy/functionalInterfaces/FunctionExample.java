package com.udemy.functionalInterfaces;

import java.util.function.Function;

public class FunctionExample {

    static Function<String, String> function = (name) -> name.concat(" :3");
    static Function<String, String> function1 = (name) -> name.concat(" *_*");

    public static void main(String[] args) {
        System.out.println(function.apply("Hello there!"));
        System.out.println(function.andThen(function1).apply("Hello there!"));
        // exec function 1 first, then function
        System.out.println(function.compose(function1).apply("Hello there!"));
    }
}
