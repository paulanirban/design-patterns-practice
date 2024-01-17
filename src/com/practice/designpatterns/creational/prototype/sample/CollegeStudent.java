package com.practice.designpatterns.creational.prototype.sample;

public class CollegeStudent extends Student {
    private String universityName;
    private int gradYear;

    CollegeStudent() {}

    public CollegeStudent(CollegeStudent student) {
        super(student);
        this.universityName = student.universityName;
        this.gradYear = student.gradYear;
    }

    public String getUniversityName() {
        return universityName;
    }

    public CollegeStudent clone() {
        return new CollegeStudent(this);
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getGradYear() {
        return gradYear;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }
}
