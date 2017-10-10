package com.ruchengxiao.assignment5;

import java.util.ArrayList;
import java.util.List;

public class ExtraCredit {
    static int rowLength;
    static int columnLength;
    public static void main(String[] args) {
        int[][] test = {{1, 2, 3, 1},
                        {4, 5, 6, 1},
                        {1, 2, 3, 1},
                        {4, 5, 6, 1},
                        {1, 2, 3, 1}};
        for (Integer i : spiralOrder(test)) {
            System.out.print(i + "->");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        rowLength = matrix.length;
        columnLength = matrix[0].length;
        helper(result, matrix, 0, 0);
        return result;
    }

    private static void helper(List<Integer> result, int[][] matrix, int rowStart, int columnStart) {
        if (rowLength % 2 != 0 && columnLength % 2 != 0
                && columnStart == rowLength / 2 && rowStart == columnLength / 2) {
            result.add(matrix[columnStart][rowStart]);
            return;
        }

        if (rowStart == columnLength / 2 || columnStart == rowLength / 2) {
            return;
        }

        for (int i = rowStart; i < columnLength - rowStart - 1; i++) {
            result.add(matrix[columnStart][i]);
        }

        for (int i = columnStart; i < rowLength - columnStart - 1; i++) {
            result.add(matrix[i][columnLength - rowStart - 1]);
        }

        for (int i = columnLength - rowStart - 1; i > rowStart; i--) {

            result.add(matrix[rowLength - columnStart - 1][i]);
        }

        for (int i = rowLength - columnStart - 1; i > columnStart; i--) {
            result.add(matrix[i][rowStart]);
        }

        helper(result, matrix, rowStart + 1, columnStart + 1);
    }
}
