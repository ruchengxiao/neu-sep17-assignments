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
}
