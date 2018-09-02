package com.udemy.functionalInterfaces;

import com.udemy.data.Student;
import com.udemy.data.StudentDatabase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

    static List<Student> studentList = StudentDatabase.getAllStudents();
    static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
    // ConsumerExample print with condition method
    static Predicate<Student> p2 = (s) -> s.getGpa() > 3.5;

    public static void filterStudentByGrade() {
        studentList.forEach((s) -> {
            if(p1.test(s)) {
                System.out.println(s.getName() + " " + s.getGradeLevel());
            }
        });
    }

    public static void filterStudentByGradeAndGpa() {
        studentList.forEach((s) -> {
            if(p1.and(p2).test(s)) {
                System.out.println(s.getName() + " " + s.getGradeLevel() + " " + s.getGpa());
            }
        });
    }

    public static void main(String[] args) {
        filterStudentByGrade();
        filterStudentByGradeAndGpa();
    }
}
