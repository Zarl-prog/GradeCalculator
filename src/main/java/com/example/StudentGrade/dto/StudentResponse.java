package com.example.studentgrade.dto;

public class StudentResponse {
    private String name;
    private int total;
    private double average;
    private String grade;

    public StudentResponse(String name, int total, double average, String grade) {
        this.name = name;
        this.total = total;
        this.average = average;
        this.grade = grade;
    }

    public String getName() { return name; }
    public int getTotal() { return total; }
    public double getAverage() { return average; }
    public String getGrade() { return grade; }
}
