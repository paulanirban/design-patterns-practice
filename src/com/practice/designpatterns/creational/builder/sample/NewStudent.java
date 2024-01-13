package com.practice.designpatterns.creational.builder.sample;

public class NewStudent {
    public static void main(String[] args) {
        StudentBuilder studentBuilder = new StudentBuilder();
        studentBuilder.setName("Anirban");
        studentBuilder.setUniversity("WBUT");

        Student stObj = new Student(studentBuilder);

        //using StudentBuilder inside Student
        StudentBuilder studentBuilder1 = Student.getBuilder();

        Student student = studentBuilder.build();
    }
}
