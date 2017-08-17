package com.java.jianzhioffer.arrayFind;

/**
 * Created by Richard Chen on 2017/5/8.
 * 3：二维数组中的查找
 */
public class ArrayFind {
    public Boolean find(int [][] array, int target){
        int col = array.length-1;
        int row = 0;
        while(col >= 0 && row <= array[0].length){
            if (array[row][col] < target){
                row++;
            }else if (array[row][col] > target){
                col--;
            }else return true;
        }
        return false;
    }
}
