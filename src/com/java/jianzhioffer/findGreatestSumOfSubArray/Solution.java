package com.java.jianzhioffer.findGreatestSumOfSubArray;

/**
 * Created by Richard Chen on 17-8-12
 * description: 28.连续子数组的最大和
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int curSum = 0;
        int maxSum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0) {
                curSum = array[i];//小于0则放弃并设置当前元素为curSum
            }else {
                curSum += array[i];//大于0则继续累加
            }
            if (curSum > maxSum) {
                maxSum = curSum;//如果比原来记录的和大则更新
            }
        }
        return maxSum;
    }
}
