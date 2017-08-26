package com.java.lintCode.binarySearch.searchMatrix;

/**
 * Created by Richard Chen on 17-8-26
 * description: 3.3:搜索二维矩阵
 * 写出一个高效的算法来搜索 m × n矩阵中的值。

 这个矩阵具有以下特性：

 每行中的整数从左到右是排序的。
 每行的第一个数大于上一行的最后一个整数。
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0) {
            if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
