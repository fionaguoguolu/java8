package com.udemy.lambdas;

import com.udemy.data.Student;
import com.udemy.data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ConsumerExample {
    static Consumer<Student> c2 = (s) -> System.out.println(s);
    static Consumer<Student> c3 = (s) -> System.out.println(s.getName());
    static Consumer<Student> c4 = (s) -> System.out.println(" " + s.getActivities());
    public static void printName() {
        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach(c3);
    }

    public static void printNameNadActivites() {
        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach(c3.andThen(c4)); // Consumer chaining
    }

    public static void printNameNadActivitesUsingCondition() {
        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach(s -> {
            if (s.getGradeLevel() >= 3) {
                c3.andThen(c4).accept(s);  // accept process one input
            }
        }); // Consumer chaining
    }

    public static void main(String[] args) {
        printNameNadActivitesUsingCondition();
    }
}
