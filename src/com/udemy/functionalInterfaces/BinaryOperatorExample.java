package com.udemy.functionalInterfaces;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    public static void main(String[] args) {
        BinaryOperator<Double> binaryOperator = (a, b) -> a * b;
        System.out.println(binaryOperator.apply(2.0, 6.0));

        BinaryOperator<Double> maxBy = BinaryOperator.maxBy((a, b) -> a.compareTo(b));
        System.out.println(maxBy.apply(2.0, 3.0));
    }
}
