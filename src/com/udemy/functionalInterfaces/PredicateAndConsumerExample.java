package com.udemy.functionalInterfaces;

import com.udemy.data.Student;
import com.udemy.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
    Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;
    BiPredicate<Integer, Double> biP = (grade, gpa) -> grade >= 3 && gpa >= 3.9;

    BiConsumer<String, List<String>> bc = (name, activites) -> {
        System.out.println(name + " " + activites);
    };

    Consumer<Student> studentConsumer = (s) -> {
        if(p1.and(p2).test(s)) {
            bc.accept(s.getName(), s.getActivities());
        }
        // Using BiPredicate
        if(biP.test(s.getGradeLevel(), s.getGpa())) {
            bc.accept(s.getName(), s.getActivities());
        }
    };

    public void printNameAndAcitivites(List<Student> students) {
        students.forEach(studentConsumer);
        // students.stream().filter(p1.and(p2)).<= how to pass result to bc?
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        new PredicateAndConsumerExample().printNameAndAcitivites(studentList);
    }
}
