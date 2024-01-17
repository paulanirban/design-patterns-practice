package com.practice.designpatterns.creational.prototype.sample;

public class Student {
    private String name;
    private int age;
    private String batchName;
    private double psp;
    private double avgBatchPsp;
    private String phoneNumber;
    private String email;


    Student() {}

    Student(Student student) {
        this.name = student.name;
        this.age = student.age;
        this.batchName = student.batchName;
        this.psp = student.psp;
        this.avgBatchPsp = student.avgBatchPsp;
        this.phoneNumber = student.phoneNumber;
        this.email = student.email;
    }

    public Student clone() {
        return new Student(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public double getAvgBatchPsp() {
        return avgBatchPsp;
    }

    public void setAvgBatchPsp(double avgBatchPsp) {
        this.avgBatchPsp = avgBatchPsp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
