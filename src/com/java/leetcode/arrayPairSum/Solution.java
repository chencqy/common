package com.java.leetcode.arrayPairSum;

import java.util.Arrays;

/**
 * Created by Richard Chen on 17-8-17
 * description: 4.Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 */
public class Solution {
    /**
     * 给定一个长度为2n(偶数)的数组，分成n个小组，返回每组中较小值的和sum，使sum尽量大
     *先排序，将相邻两个数分为一组，每组较小数都在左边，求和即可
     * 
     假设对于每一对i，bi >= ai。
     定义Sm = min（a1，b1）+ min（a2，b2）+ … + min（an，bn）。最大的Sm是这个问题的答案。由于bi >= ai，Sm = a1 + a2 + … + an。
     定义Sa = a1 + b1 + a2 + b2 + … + an + bn。对于给定的输入，Sa是常数。
     定义di = | ai - bi |。由于bi >= ai，di = bi-ai, bi = ai+di。
     定义Sd = d1 + d2 + … + dn。
     所以Sa = a1 + (a1 + d1) + a2 + (a2 + d2) + … + an + (an + di) = 2Sm + Sd , 所以Sm =（Sa-Sd）/ 2。为得到最大Sm，给定Sa为常数，需要使Sd尽可能小。
     所以这个问题就是在数组中找到使di（ai和bi之间的距离）的和尽可能小的对。显然，相邻元素的这些距离之和是最小的。
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}
