package com.ruchengxiao.assignment2;
/*
* This is the second problem
* */
public class AddDigits {

    public static void main(String[] args) {
        AddDigits test = new AddDigits();
        System.out.println(test.addDigits(15));
        System.out.println(test.addDigits(155));
        System.out.println(test.addDigits(1556));

    }

    public int addDigits(int input) {
        int result = 0;

        while (input >= 10) {
            result += input % 10;
            input /= 10;
            if (input < 10) {
                result += input;
                input = result;
                if (input >= 10) {
                    result = 0;
                }
            }
        }
        return result;
    }
}
