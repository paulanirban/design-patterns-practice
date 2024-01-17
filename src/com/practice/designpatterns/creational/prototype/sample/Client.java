package com.practice.designpatterns.creational.prototype.sample;

public class Client {
    public static void main(String[] args) {
        Registry<Student> studentRegistry = new Registry<>();
        fillRegistry(studentRegistry);

        Student sid = studentRegistry.get("janBatchStudent").clone();
        sid.setName("Sid");

        Student professionalStudent = studentRegistry.get("pro").clone();
        professionalStudent.setName("Pro Student");

        Student collegeStudent = studentRegistry.get("college").clone();

        System.out.println("debug");
    }

    public static void fillRegistry(Registry registry) {
        Student janBatchStudent = new Student();
        janBatchStudent.setBatchName("Jan Batch");
        janBatchStudent.setAvgBatchPsp(89.0);

        registry.register("janBatchStudent", janBatchStudent);

        CollegeStudent collegeBatchStudent = new CollegeStudent();
        collegeBatchStudent.setGradYear(2023);
        collegeBatchStudent.setUniversityName("XYZ");
        collegeBatchStudent.setBatchName("College Batch");
        collegeBatchStudent.setAvgBatchPsp(95.0);

        registry.register("college", collegeBatchStudent);

        ProfessionalStudent professionalStudent = new ProfessionalStudent();
        professionalStudent.setSalary(200000);
        professionalStudent.setCompanyName("TCS");
        professionalStudent.setBatchName("College Batch");
        professionalStudent.setAvgBatchPsp(92.0);

        registry.register("pro", professionalStudent);
    }
}
