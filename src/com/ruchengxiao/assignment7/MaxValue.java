package com.ruchengxiao.assignment7;

import java.util.Arrays;
//Problem 1
public class MaxValue extends Thread{
    private int lo, hi;
    private int[] arr;
    private int ans = Integer.MIN_VALUE;

    public MaxValue(int[] arr, int lo, int hi) {
        this.arr = arr;
        this.lo = lo;
        this.hi = hi;
    }

    @Override
    public void run() {
        for (int j = lo; j < hi; j++){
            int temp = arr[j];
            if (temp > ans){
                ans = temp;
            }
        }
    }

    public static int sum(int[] arr) throws InterruptedException {
        int len = arr.length;
        int ans = Integer.MIN_VALUE;

        // Create and start 4 threads.
        MaxValue[] ts = new MaxValue[4];
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                ts[i] = new MaxValue(arr, (i * len) / 4, len);
            } else {
                ts[i] = new MaxValue(arr, (i * len) / 4, ((i + 1) * len / 4));
            }
            ts[i].start();
        }

        // Wait for the threads to finish and sum their results.
        for (int i = 0; i < 4; i++) {
            ts[i].join();
            if (ans < ts[i].ans) {
                ans = ts[i].ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws InterruptedException {
        int size = -1;
        while (true) {
            size = (int) (Math.random() * 10);
            if (size > 4) {
                break;
            }
        }

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }

        System.out.println("Sum: " + Arrays.toString(arr));
        System.out.println(sum(arr));
    }

}
