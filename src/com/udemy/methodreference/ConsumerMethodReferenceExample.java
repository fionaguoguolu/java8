package com.udemy.methodreference;

import com.udemy.data.Student;

import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {

    static Consumer<Student> c2 = System.out::println;

    public static void main(String[] args) {
    }
}
