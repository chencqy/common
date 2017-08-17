package com.java.jianzhioffer.reOrderArray;

/**
 * Created by dell on 2017/7/25.
 * 12.输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().reOrderArray(new int[]{1,2,3,4,5,6,7,});
    }
    public void reOrderArray(int [] array) {
        if (array.length == 0 || array.length == 1){
            return;
        }
        int oddCount = 0;//奇数的个数
        int oddBegin = 0;//偶数从0开始
        int []newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {//统计奇数的个数
            if ((array[i] % 2) == 1) {
                oddCount++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if ((array[i] % 2) == 1) {
                newArray[oddBegin++] = array[i];//如果是奇数，从0位置开始添加
            } else newArray[oddCount++] = array[i];//如果为偶数则从oddCount开始添加
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
            System.out.println(array[i]);
        }
    }
}
