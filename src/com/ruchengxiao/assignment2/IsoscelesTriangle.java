package com.ruchengxiao.assignment2;

public class IsoscelesTriangle {

    public static void main(String[] args) {
        IsoscelesTriangle test = new IsoscelesTriangle();
        test.printIsoscelesTriangle(6);
    }

    public void printIsoscelesTriangle(int n) {
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
