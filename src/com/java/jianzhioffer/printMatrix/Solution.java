package com.java.jianzhioffer.printMatrix;

import java.util.ArrayList;

/**
 * Created by dell on 2017/8/1.
 * 18.输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
public class Solution {
    public static void main(String[] args) {
        int [][] matrix = {{1,2},{3,4},{5,6},{7,8},{9,10}};
        ArrayList<Integer> list = new Solution().printMatrix(matrix);
        System.out.println(list);
    }
    ArrayList<Integer> numbers = new ArrayList<>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix.length == 0){
            return null;
        }
        int rows = matrix.length;//有多少行
        int columns = matrix[0].length;//有多少列
        int start = 0;
        while (rows > start * 2 && columns > start * 2){
            printMatrixInCircle(matrix, rows, columns, start);
            start++;
        }
        return numbers;
    }

    public void printMatrixInCircle(int [][] matrix, int rows, int columns, int start){
        int endRow = rows - start - 1;
        int endCol = columns - start - 1;
        //从左到右打印一行
        for (int i = start; i <= endCol; i++) {
            numbers.add(matrix[start][i]);
        }
        //从上到下打印一列
        if (endRow > start){
            for (int i = start + 1; i <= endRow; i++) {
                numbers.add(matrix[i][endCol]);
            }
        }
        //从右到左打印一行
        if (endCol > start && endRow > start){
            for (int i = endCol - 1; i >= start; i--) {
                numbers.add(matrix[endRow][i]);
            }
        }
        //从下到上打印一列
        if (endCol > start && endRow - 1 > start){
            for (int i = endRow - 1; i >= start + 1 ; i--) {
                numbers.add(matrix[i][start]);
            }
        }
    }
}
