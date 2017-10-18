package com.ruchengxiao.assignment6;
/*
* This is problem 1
* */
public class MyIndexOutOfBoundException extends Exception{
    int lowerBound;
    int upperBound;
    int index;

    public static void main(String[] args) {
        int index = 10;
        try {
            indexOutOfBoundException(index);
        } catch (MyIndexOutOfBoundException ex) {
            ex.printStackTrace();
        }


    }
    static void indexOutOfBoundException(int index) throws MyIndexOutOfBoundException{
        if (index <= 9 && index >= 0) {
            System.out.println("Pass");
        } else {
            throw new MyIndexOutOfBoundException(index);
        }
    }

    public MyIndexOutOfBoundException(int index) {
        lowerBound = 0;
        upperBound = 9;
        this.index = index;
        System.out.println("\"Error Message: " + "Index: " + this.index + ", but Lower bound: "
                         + lowerBound + ", Upper bound: " + upperBound + "\"" + "\n");
    }
}
