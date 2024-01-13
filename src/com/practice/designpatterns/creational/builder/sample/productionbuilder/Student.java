package com.practice.designpatterns.creational.builder.sample.productionbuilder;

public class Student {
    private String name;
    private int age;
    private boolean isStudent;
    private String university;
    private double gpa;
    private int phone;
    private String email;
    private String batchName;

    private Student(Builder builder) {
        this.name = builder.getName();
        this.age = builder.getAge();
        this.isStudent = builder.isStudent();
        this.university = builder.getUniversity();
        this.gpa = builder.getGpa();
        this.phone = builder.getPhone();
        this.email = builder.getEmail();
        this.batchName = builder.getBatchName();

        if(this.age < 0) throw new RuntimeException();
        if(this.gpa < 0 || this.gpa>100) throw new RuntimeException();
    }
    public static Builder getBuilder() {
        return new Builder();
    }
    public static class Builder {
        private String name;
        private int age;
        private boolean isStudent;
        private String university;
        private double gpa;
        private int phone;
        private String email;

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public boolean isStudent() {
            return isStudent;
        }

        public Builder setStudent(boolean student) {
            isStudent = student;
            return this;
        }

        public String getUniversity() {
            return university;
        }

        public Builder setUniversity(String university) {
            this.university = university;
            return this;
        }

        public double getGpa() {
            return gpa;
        }

        public Builder setGpa(double gpa) {
            this.gpa = gpa;
            return this;
        }

        public int getPhone() {
            return phone;
        }

        public Builder setPhone(int phone) {
            this.phone = phone;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getBatchName() {
            return batchName;
        }

        public Builder setBatchName(String batchName) {
            this.batchName = batchName;
            return this;
        }

        private String batchName;

        public Student build() {
            return new Student(this);
        }
    }
}
