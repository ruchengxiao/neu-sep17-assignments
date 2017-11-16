package com.ruchengxiao.MidTermPartB; // score 10

public class Question4 {
    int result;
    public static void main(String[] args) {
        Question4 test = new Question4();
        System.out.println(test.countNumberOfPossibleWays(6, 6, 36));
    }


    public int countNumberOfPossibleWays(int m, int n, int x) {

        result = 0;
        int sum = 0;
        helper(n, m,1, sum, x);
        return result;
    }

    private void helper(int n, int m, int count, int sum, int x) {
        if (sum == x && count == n + 1) {
            //System.out.println(result);
            result++;
            return;
        }

        if (count == n + 1) {
            return;
        }

        for (int i = 1; i <= m; i++) {
            sum += i;
            helper(n, m,count + 1, sum, x);
            sum -= i;
        }
    }


}
