package com.ruchengxiao.assignment7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
//Problem 5
public class FindPartition {

    public static void main(String[] args) {
        FindPartition test = new FindPartition();
        System.out.println(test.findPartition(new int[]{1, 5, 5, 1}));
    }

    public boolean findPartition (int arr[]) {
        int len = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 == 1) {
            return false;
        }

        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = false;
        }
        dp[0] = true;
        for(int i = 0; i < len; i++){
            for(int j = sum ; j >= arr[i]; j--){
                dp[j] |= dp[j - arr[i]];
            }
        }

        return dp[sum];
    }
}
