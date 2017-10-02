package com.ruchengxiao.assignment4;
//This is solution for problem 4
public class Course {
    private String name;
    private int numberOfStudent;
    private Student[] students;

    public Course(String title) {
        numberOfStudent = 0;
        name = title;
        students = new Student[10];
    }
    public Student[] getStudents() {
        return students;
    }

    public boolean isFull() {
        return numberOfStudent == 10;
    }

    public void registerStudent(Student student) {
        students[numberOfStudent] = student;
        numberOfStudent++;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }
}

