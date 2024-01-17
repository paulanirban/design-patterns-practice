package com.practice.designpatterns.creational.prototype.sample;

public class ProfessionalStudent extends Student {
    private String companyName;
    private int salary;

    ProfessionalStudent() {}

    ProfessionalStudent(ProfessionalStudent student) {
        super(student);
        this.companyName = student.companyName;
        this.salary = student.salary;
    }

    public ProfessionalStudent clone() {
        return new ProfessionalStudent(this);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
