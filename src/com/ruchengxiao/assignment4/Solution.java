/* Good Work
 * Score 9.8 + extra credit 1.8; Total score 10
 */
package com.ruchengxiao.assignment4;

import java.util.Arrays;

//These are solutions for problem 1, problem 5
public class Solution {
    public static void main(String[] args) {
        System.out.println(reformatString("1abs-sdas", 3));
        double[] arr1 = {1, 2};
        double[] arr2 = {3, 4};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    public static String reformatString(String str, int K) { // score 1.8
        String dashDeleted = str.replaceAll("-", "").toUpperCase(); // we asked not to use these methods for this assignment
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
    public String intToRoman(int num) { // score 2
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

    //Extra Credit
    public static double findMedianSortedArrays(double[] nums1, double[] nums2) { // extra credit 1.8
        double[] result = new double[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            result[nums1.length + i] = nums2[i];
        }

        Arrays.sort(result); // we asked not to use these methods for this assignment
        int length = result.length - 1;
        return (result[length / 2] + result[(length + 1) / 2]) / 2;
    }
}
