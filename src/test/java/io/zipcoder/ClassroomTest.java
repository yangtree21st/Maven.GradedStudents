package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ClassroomTest {



    @Test
    public void constructorTest(){
        Classroom classroom = new Classroom();

        Student[] expect = new Student[30];
        Student[] actual = classroom.getStudents();

        Assert.assertEquals(expect,actual);
    }


    @Test
    public void constructorTest2(){
        Classroom classroom = new Classroom(20);

        Student[] expect = new Student[20];
        Student[] actual = classroom.getStudents();

        Assert.assertEquals(expect,actual);
    }



    @Test
    public void getAverageExamScoreTest() {
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };
        double expectedAverage = 125.0;

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = new Student[]{s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double actualAverage = classroom.getAverageExamScore();

        //Then
        Assert.assertEquals(expectedAverage, actualAverage, 0.1);
    }


    @Test
    public void addStudentTest() {
       Classroom classroom = new Classroom();
        Double[] testScore1 = {125.0, 225.0,100.0};
        Double[] testScore2 = {25.0, 325.0,100.0};

        Student student1 = new Student("First","last",testScore1);
        Student student2 = new Student("Second","last",testScore2);
       classroom.addStudent(student1);
       classroom.addStudent(student2);

       classroom.containStudent(student1);
        classroom.containStudent(student2);
    }



    @Test
    public void removeStudent() {
//        Given
        String firstname = "first";
        String lastname = "last";

        Classroom classroom = new Classroom();
        Student student = new Student(firstname,lastname,new Double[]{1000.0});



//        When
        classroom.removeStudent(firstname,lastname);

//       Then
        Assert.assertFalse(classroom.containStudent(student));
    }





    @Test
    public void getStudentsByScore() {
        // Given
    Double[] firstScore = {100.0,50.0};
    Double[] secondScore = {20.0,20.0};
    Student student1 = new Student("student","one",firstScore);
    Student student2 = new Student("student", "two",secondScore);

    List<Student> expectStudents = new ArrayList<Student>(Arrays.asList(student1,student2));

    Student[] students = new Student[]{student2,student1};
    Classroom classroom = new Classroom(students);

        // When

        List<Student> actualStudents = Arrays.asList(classroom.getStudentsByScore());

        // Then
        Assert.assertEquals(expectStudents,actualStudents);

    }

    @Test
    public void getGradeBook() {

        // Given
    Student s1 = new Student("student","one",new Double[]{10.5});
    Student s2 = new Student("student","two",new Double[]{20.5});
    Student s3 = new Student("student", "third", new Double[]{30.5});
    Student s4 = new Student("student","four",new Double[]{40.5});
    Student s5 = new Student("student", "five",new Double[]{50.5});

        Map<Student,Grade> expectGradeBook = new HashMap<>();
        expectGradeBook.put(s1,Grade.D);
        expectGradeBook.put(s2,Grade.D);
        expectGradeBook.put(s3,Grade.C);
        expectGradeBook.put(s4,Grade.B);
        expectGradeBook.put(s5,Grade.A);

        Classroom classroom = new Classroom(new Student[]{s2,s1,s5,s4,s3});

        // When
        Map<Student,Grade> actualGradeBook = classroom.getGradeBook();

        // Then
        Assert.assertEquals(expectGradeBook,actualGradeBook);
    }
}