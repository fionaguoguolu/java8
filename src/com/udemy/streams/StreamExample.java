package com.udemy.streams;

import com.udemy.data.Student;
import com.udemy.data.StudentDatabase;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExample {

    public static void main(String[] args) {
        Map<String, Double> nameGpaMap = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.toMap(Student::getName, Student::getGpa));
        System.out.println(nameGpaMap);

        // map function example
        // get a list of student names
        System.out.println(
                StudentDatabase.getAllStudents().stream().map(Student::getName).collect(Collectors.toList())
        );

        // flatMap
        // takes a stream of collections
        // Stream<List> Stream<Array>

        System.out.println(
                StudentDatabase.getAllStudents()  // List<Student>
                        .stream() // Stream<Student>
                        .map(Student::getActivities)  // Stream<List<String>>
                        .flatMap(List::stream)  // Stream<String>
                        .distinct()
                        .collect(Collectors.toList())  // List<String>
        );

        // sort students by name
        System.out.println(
                StudentDatabase.getAllStudents()
                    .stream()
                        // optional, using comparator String::compareTo
                    .sorted(Comparator.comparing(Student::getName, String::compareTo))
                    .map(Student::getName)
                    .collect(Collectors.toList())
        );

        // reduce
        // terminal operation
        // reduce stream to a single value
        System.out.println(
                IntStream.range(1, 11).reduce(0, Integer::sum)
        );

        // get the highest GPA student
        System.out.println(
                StudentDatabase.getAllStudents()
                    .stream()
                    .sorted(Comparator.comparing(Student::getGpa).reversed())
                    .limit(1)
                    .collect(Collectors.toList()).get(0)
        );
        // alternative
        System.out.println(
                StudentDatabase.getAllStudents()
                    .stream()
                    .reduce((s1, s2) ->
                            s1.getGpa() < s2.getGpa() ? s2 : s1)
                    .get()
        );

        // get sum of all the notebooks students have
        System.out.println("Sum of all notebooks = " +
                StudentDatabase.getAllStudents()
                    .stream()
                        .map(Student::getNoteBooks)
                    .reduce(Integer::sum).get()
        );
    }
}
