package io.zipcoder;

import java.lang.reflect.Array;
import java.util.*;

import io.zipcoder.Grade;
public class Classroom {

   private Student[] students ;

   public Classroom(Student[] students){
       this.students = students;
   }
   public Classroom(int maxNumberOfStudents){
       this.students = new Student[maxNumberOfStudents];
   }

   public  Classroom(){

       this(30);
   }

   public Student[] getStudents(){
      return students;
   }

   public Double getAverageExamScore(){
       Double sum = 0.0;
       for(Student each :students){
           sum += each.getAverageExamScore();
       }
       return sum/(students.length);
   }


   public boolean containStudent (Student student){
       return convertToArraylist(students).contains(student);
   }

   public void addStudent(Student student){
     ArrayList studentList = convertToArraylist(students);
     studentList.add(student);
     studentList.toArray();

   }


   public ArrayList convertToArraylist(Student[] students){
       ArrayList arrayList = new ArrayList();
       for(int i =0 ; i < students.length;i++){
            arrayList.add(students[i] );
       }
       return arrayList;
   }

   public void removeStudent(String firstName, String lastName){
       ArrayList<Student> studentList = convertToArraylist(students);

       for(Student student : students)
           if( student.getLastName()== lastName && student.getFirstName()== firstName){
               studentList.remove(student);
           }

       Student[] returnStudent = new Student[studentList.size()];
          this.students = studentList.toArray(returnStudent);

   }

   public Student[] getStudentsByScore(){
       ArrayList<Student> scoredStudents = new ArrayList<Student>(Arrays.asList(students));
       compareStudents comparator = new compareStudents();
       scoredStudents.sort(comparator);
       Student[] studentsArr = new Student[scoredStudents.size()];
        return scoredStudents.toArray(studentsArr);

   }

   public Map <Student, Grade > getGradeBook(){
       Map<Student, Grade >gradeBook = new HashMap<>();
       Student[] orderSt =  getStudentsByScore();
       for( int i = 0 ; i <orderSt.length; i++){
           Double percentageGrade = (double) (i+1) / orderSt.length;

           if(percentageGrade > .9) {
               gradeBook.put(orderSt[i], Grade.A);
           } else if ( percentageGrade > .71) {
               gradeBook.put(orderSt[i], Grade.B);
           }
               else if ( percentageGrade > .50) {
                   gradeBook.put(orderSt[i],Grade.C);
               } else if  ( percentageGrade> .11) {
               gradeBook.put(orderSt[i], Grade.D);
           } else
               gradeBook.put(orderSt[i],Grade.F);

           }
       return gradeBook;
       }

    }


