package com.java.jianzhioffer.isContinuous;

/**
 * Created by Richard Chen on 17-8-20
 * description: 44.扑克牌的顺序：从扑克牌中随机抽取5张牌，判断是不是一个顺子，大小王是癞子。
 */
public class Solution {
    /**
     * max 记录 最大值
     min 记录  最小值
     min ,max 都不记0
     满足条件 1 max - min <5
             2 除0外没有重复的数字(牌)
             3 数组长度 为5

     */
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        int len = numbers.length;
        int[] num = new int[14];
        int min = 14;
        int max = -1;
        num[0] = -2;
        for (int i = 0; i < len; i++) {
            num[numbers[i]]++;
            if (numbers[i] == 0) {
                continue;
            }
            if (num[numbers[i]] > 1) {
                return false;
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        if (max - min < 5) {
            return true;
        }
        return false;
    }

}
