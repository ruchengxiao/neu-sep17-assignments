package com.ruchengxiao.MidTermPartB;

public class Question2 {
    public static void main(String[] args) {
        Question2 test = new Question2();
        System.out.println(1);
        System.out.println(test.arrangeCoins(5));
        System.out.println(test.arrangeCoins(10));
        System.out.println(test.arrangeCoins(11));
        System.out.println(test.arrangeCoins(1714636915));
    }

    public int arrangeCoins(int n) {
        int start = 0;
        int end = n;
        int mid = 0;
        while (start <= end){
            mid = (start + end) >>> 1;
            if ((0.5 * mid * mid + 0.5 * mid ) <= n){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start - 1;
    }
}
