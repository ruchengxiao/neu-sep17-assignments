package com.ruchengxiao.MidTermPartB; // score 7

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Question3 {
    public static void main(String[] args) {
        Question3 test = new Question3();
        int[] a = {6, 6, 1};
        System.out.println(test.minMoves(a));
    }

    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }

        return sum - min * nums.length;
    }


}
