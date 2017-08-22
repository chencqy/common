package com.java.lintCode.removeDuplicates;

/**
 * Created by Richard Chen on 17-8-22
 * description:2.3 :删除排序数组中的重复数字
 *                  给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，并且返回新的数组的长度。
                    不要使用额外的数组空间，必须在原地没有额外空间的条件下完成。
 */
public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int low = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[low] != nums[i]) {
                nums[low + 1] = nums[i];
                low++;
                count++;
            }
        }
        return count;
    }
}
