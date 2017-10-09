package com.ruchengxiao.assignment5;

import java.util.ArrayList;
import java.util.List;

public class ExtraCredit {
    int rowLength;
    int columnLength;
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        rowLength = matrix.length;
        columnLength = matrix[0].length;
        helper(matrix, 0, 0);
        return result;
    }

    private void helper(int[][] matrix, int rowStart, int columnStart) {
        for (int i = rowStart; i < matrix.length - 2 * rowStart; i++) {

        }

        helper(matrix, rowStart + 1, columnStart + 1);
    }
}
