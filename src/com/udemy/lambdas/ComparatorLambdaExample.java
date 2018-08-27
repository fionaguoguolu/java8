package com.udemy.lambdas;

import java.util.Comparator;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println(comparator.compare(1, 2));

        Comparator<Integer> comparatorLambda = (Integer a, Integer b) -> a.compareTo(b);
        System.out.println(comparatorLambda.compare(1, 2));
    }
}
