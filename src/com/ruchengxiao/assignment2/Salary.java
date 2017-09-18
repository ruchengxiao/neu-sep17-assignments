package com.ruchengxiao.assignment2;
/*
* This is the first problem
* */
public class Salary {

    public static void main(String[] args) {
        Salary test = new Salary();
        System.out.println(test.employeeSalary(24));
        System.out.println(test.employeeSalary(27));
        System.out.println(test.employeeSalary(42));
        System.out.println(test.employeeSalary(100));
    }

    public double employeeSalary(double hours) {
        double salary = 0.0;

        salary += Math.min(36, hours) * 15.0;

        if (hours > 36) {
            salary += Math.min(5, hours - 36) * 15.0 * 1.5;
        }

        if (hours - 36 > 5) {
            salary += (Math.min(48,  hours) - 36 - 5) * 15.0 * 2.0;
        }

        return salary;
    }
}
