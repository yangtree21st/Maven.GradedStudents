package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {



    String firstName;
    String lastName;
    ArrayList<Double> examScores;


    Student(String firstName, String lastName, Double[] tesScores ){
        this.firstName = firstName;
        this.lastName = lastName;
        examScores = new ArrayList<>();
        examScores.addAll(Arrays.asList(tesScores));
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamScores(){
        String scores = "Exam Scores:\n";
        for (int i = 0; i < examScores.size(); i++){
            scores += " \tExam " + (i+1) + " -> " + examScores.get(i).intValue() + "\n";
        }
        return scores;
    }


    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }

    public void addExamScore(Double examScore){
          examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore){
       int position = examNumber-1;
       examScores.add(position,newScore);
    }

    public Double getAverageExamScore(){
        Double sum = 0.0;
        Double avera = 0.0 ;
        for(int i = 0 ;i <= examScores.size();i++){
            sum += examScores.get(i);
        }
        return avera = sum/(examScores.size());
    }


    public String toString() {
        String s = "Student Name: " + firstName + " " + lastName + "\n" + "> Average Score: " + getAverageExamScore().intValue() + "\n"
                + getExamScores();
        return s;
    }
    }


