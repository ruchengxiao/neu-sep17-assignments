package com.ruchengxiao.assignment2;
/*
* This is the third problem
* */
public class PerfectNumbers {

    public static void main(String[] args) {
        PerfectNumbers test = new PerfectNumbers();
        test.printPerfectNumbers(10);
        test.printPerfectNumbers(100);
        test.printPerfectNumbers(1000);
    }

    public void printPerfectNumbers(int n) {
        int count = 1;

        while (count <= n) {
            int result = 0;
            int divisor = 1;
            while (divisor < count) {
                if (count % divisor == 0) {
                    result += divisor;
                }
                divisor++;
            }
            if (result == count) {
                System.out.println(count);
            }
            count++;
        }

    }
}
