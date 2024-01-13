package com.practice.designpatterns.creational.builder.sample;

import java.util.Map;

public class Student {
    String name;
    int age;
    boolean isStudent;
    String university;
    double gpa;
    int phone;
    String email;
    String batchName;

    public static StudentBuilder getBuilder() {
        return new StudentBuilder();
    }

    Student(StudentBuilder studentBuilder) {
        this.name = studentBuilder.getName();
        this.age = studentBuilder.getAge();
        this.isStudent = studentBuilder.isStudent();
        this.university = studentBuilder.getUniversity();
        this.gpa = studentBuilder.getGpa();
        this.phone = studentBuilder.getPhone();
        this.email = studentBuilder.getEmail();
        this.batchName = studentBuilder.getBatchName();

        //before initializing the object we have all the attributes.
        //Perform validations here
        if(this.age < 0) throw new RuntimeException();
        if(this.gpa < 0 || this.gpa>100) throw new RuntimeException();
    }

    Student(Map<String, Object> params) {
        if (params.containsKey("Name")) {

            // Explicit type conversion.
            // No compile type safety.
            // Possibility of params mistyped
            // nmae
            this.name = (String) params.get("Name");
        }
        if (age < 0) throw new RuntimeException();
        if (gpa < 0 || gpa > 100) throw new RuntimeException();

//        if (age > psp) throw
    }

    Student(String name, int age, String university) {
        if (age < 0) throw new RuntimeException();
        // all other validation checks.
        this.name = name;
        this.age = age;
        this.university = university;
    }

    Student(String name, double gpa, String batchName) {
        if (gpa < 0 || gpa > 100) throw new RuntimeException();
        // all other validation checks.
        this.name = name;
        this.gpa = gpa;
        this.batchName = batchName;
    }
}
