package com.udemy.functionalInterfaces;

import com.udemy.data.Student;
import com.udemy.data.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudentExample {
    static List<Student> studentList = StudentDatabase.getAllStudents();

    static Function<List<Student>, Map<String, Double>> getNameGpaAsMap = (studentList) -> {
        Map<String, Double> nameGpaMap = new HashMap<>();
        studentList.forEach((s) -> nameGpaMap.put(s.getName(), s.getGpa()));
        return nameGpaMap;
    };

    public static void main(String[] args) {
        Map<String, Double> map = getNameGpaAsMap.apply(studentList);
        System.out.println(map);

    }
}
