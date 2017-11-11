package com.ruchengxiao.assignment4;
//This is solution for problem 4
public class Course { // score 2
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

    public void registerStudent(Student student) { // check the condition where a single student can register multiple times
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

class Student {
    String name;
    long id;

    public Student(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

