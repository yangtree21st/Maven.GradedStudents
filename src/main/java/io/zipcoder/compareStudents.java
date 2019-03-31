package io.zipcoder;

import java.util.Comparator;

public class compareStudents implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {



        return o1.getAverageExamScore().compareTo(o2.getAverageExamScore());
    }
}