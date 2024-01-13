package com.practice.designpatterns.creational.builder.sample.productionbuilder;

public class Client {
    public static void main(String[] args) {
        Student student = Student.getBuilder()
                .setName("Anirban")
                .setAge(37)
                .setStudent(true)
                .setGpa(8.0)
                .setUniversity("WBUT")
                .build();

        System.out.println("DEBUG");
    }
}
