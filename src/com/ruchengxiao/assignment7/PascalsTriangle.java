package com.ruchengxiao.assignment7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Problem 3
public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle test = new PascalsTriangle();
        test.printPascalTriangle(-1);
    }

    public void printPascalTriangle(int n){
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0) {
            return;
        }

        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);
        System.out.println(1);

        for (int i = 1; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> prev = result.get(i - 1);
            temp.set(0, prev.get(0));
            for (int j = 1; j < i; j++) {
                temp.add(j, prev.get(j - 1) + prev.get(j));
            }
            temp.add(1);
            for (int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j) + " " );
            }
            System.out.println();
            result.add(temp);
        }
    }
}
