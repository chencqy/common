package com.java.jianzhioffer.getLeastNumbers;

import java.util.ArrayList;

/**
 * Created by Richard Chen on 17-8-11
 * description: 28.输入n个整数，找出其中最小的K个数
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        int length = input.length;
        if (length == 0 || k > length) {
            return al;
        }
        /**
         * 冒泡排序的思想，只不过最外层循环K次就可以了，也就是说不用全部排序，只挑出符合提议的K个就可以。
         */
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (input[j] < input[j + 1]){
                    int temp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = temp;
                }
            }
            al.add(input[length - i - 1]);
        }
        return al;
    }
}
