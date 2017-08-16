package com.java.leetcode.twoSum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Richard Chen on 17-8-16
 * description: 1.Given an array of integers, return indices of the two numbers such that they add up to a specific target.
             You may assume that each input would have exactly one solution, and you may not use the same element twice.
 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class Solution {
    public static void main(String[] args) {
        int[] test = {2,7,11,15};
        int[] result = new Solution().twoSum(test, 9);
        System.out.println(Arrays.toString(result));
    }
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
