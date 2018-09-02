package com.udemy.functionalInterfaces;

import com.udemy.data.Student;
import com.udemy.data.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {
    static List<Student> studentList = StudentDatabase.getAllStudents();

    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction =
            (studentList, predicate) -> {
        Map<String, Double> nameGpaMap = new HashMap<>();
        studentList.stream().filter(predicate).forEach((s) -> {
            nameGpaMap.put(s.getName(), s.getGpa());
        });
        return nameGpaMap;
    };

    public static void main(String[] args) {
        System.out.println(biFunction.apply(studentList, (s) -> s.getGpa() >= 3.9));
    }

}
