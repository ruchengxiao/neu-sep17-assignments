package com.ruchengxiao.MidTermPartB;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Question1 { // score 6

    public static void main(String[] args) {
        Question1 test = new Question1();
        int[] a = {9, 4, 8, 7, 5, 1, 3};
        test.reverseEvenIndices(a);
        System.out.println(Arrays.toString(a));
        int[] b = {6, 4, 1, 0, 3, 2};
        test.reverseEvenIndices(b);
        System.out.println(Arrays.toString(b));
        int[] c = {1, 2, 3};
        test.reverseEvenIndices(c);
        System.out.println(Arrays.toString(c));
    }

    public int[] reverseEvenIndices(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (left % 2 == 0 || right % 2 == 0) {
                if (left % 2 !=0) {
                    left++;
                } else if (right % 2 != 0) {
                    right--;
                }

                swap(nums, left, right);
            }

            left++;
            right--;
        }

        return null;
    }

    void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
