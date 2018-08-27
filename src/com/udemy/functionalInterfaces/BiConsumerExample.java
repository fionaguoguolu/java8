package com.udemy.functionalInterfaces;

import com.udemy.data.Student;
import com.udemy.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void nameAndActivities() {
        List<Student> studentList = StudentDatabase.getAllStudents();

        BiConsumer<String, List<String>> biConsumer = (name, activities) ->
            System.out.println("name: " + name + " activities: " + activities)
        ;

        studentList.forEach(
                student -> biConsumer.accept(
                        student.getName(), student.getActivities()));
    }

    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (a, b) -> {
            System.out.println("a: " + a + " b: " + b);
        };
        biConsumer.accept("a", "b");

        BiConsumer<Integer, Integer> multiply = (a, b) -> {
            System.out.println("a x b = " + a * b);
        };

        BiConsumer<Integer, Integer> division = (a, b) -> {
            System.out.println("a x b = " + a / b);
        };

        multiply.andThen(division).accept(10, 5);

        nameAndActivities();
    }
}
