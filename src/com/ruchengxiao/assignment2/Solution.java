package com.ruchengxiao.assignment2;
/*
* This file include 1, 2, 3, 6 problem
* */
public class Solution {
    /*
    * This is the first problem
    */
    public static double employeeSalary(double hours) {
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

    /*
     * This is the second problem
     */
    public static int addDigits(int input) {
        int result = 0;

        while (input >= 10) {
            result += input % 10;
            input /= 10;
            if (input < 10) {
                result += input;
                input = result;
                if (input >= 10) {
                    result = 0;
                }
            }
        }
        return result;
    }

    /*
     * This is the third problem
     */
    public static void printPerfectNumbers(int n) {
        int count = 2;

        while (count <= n) {
            int sum = 1;
            for (int divisor = 2; divisor <= Math.sqrt(count); divisor++) {
                if (count % divisor == 0) {
                    sum += divisor;
                    if (divisor != count / divisor) {
                        sum += count / divisor;
                    }
                }
            }

            if (sum == count) {
                System.out.println(count);
            }
            count++;
        }

    }

    /*
     * This is the sixth problem
     */
    public static void printIsoscelesTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    System.out.print("*");
                } else if (i == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

}
