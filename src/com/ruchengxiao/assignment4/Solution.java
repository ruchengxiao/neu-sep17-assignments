package com.ruchengxiao.assignment4;

//These are solutions for problem 1, problem 5
public class Solution {
    public static void main(String[] args) {
        System.out.println(reformatString("1abs-sdas", 3));
    }

    public static String reformatString(String str, int K) {
        String dashDeleted = str.replaceAll("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder();
        int firstLength = dashDeleted.length() % K;
        if (firstLength % K == 0) {
            for (int i = 0; i < dashDeleted.length() / K; i++) {
                sb.append(dashDeleted.substring(i * K, i * K + K));
                if (i != dashDeleted.length() / K - 1) {
                    System.out.println(i);
                    sb.append("-");
                }
            }
        } else {
            int nextPointer = 0;
            for (int i = 0; i < dashDeleted.length() / K + 1; i++) {
                if (i == 0) {
                    sb.append(dashDeleted.substring(0, firstLength));
                    nextPointer = firstLength;
                } else {
                    sb.append(dashDeleted.substring(nextPointer, nextPointer + K));
                    nextPointer = nextPointer + K;
                }

                if (i != dashDeleted.length() / K) {
                    sb.append("-");
                }
            }
        }

        return sb.toString();
    }

    //This is the solution for problem 5;
    public String intToRoman(int num) {
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            while (num >= numbers[i]) {
                num -= numbers[i];
                sb.append(romans[i]);
            }
        }

        return sb.toString();
    }
}
