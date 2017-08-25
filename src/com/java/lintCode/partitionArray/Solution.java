package com.java.lintCode.partitionArray;

/**
 * Created by Richard Chen on 17-8-25
 * description:2.10 : 数组划分:
 *                    给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），使得：
 所有小于k的元素移到左边
 所有大于等于k的元素移到右边
 返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().partitionArray(new int[]{9,9,9,8,9,8,7,9,8,8,8,9,8,9,8,8,6,9},9);
    }

    /**
     * 双指针，将小于k的元素放在左边，大于k的元素放在右边
     */
    public int partitionArray(int[] nums, int k) {
        int left = 0;int right = nums.length-1;
        while(left < right){
            while(left < nums.length && nums[left] < k) {
                left++;
            }
            while(right >= 0 && nums[right] >= k){
                right--;
            }
            if(left >= right){
                break;
            }
            swap(left, right, nums);
        }
        return left;
    }
    private void swap(int l, int r, int[] A) {
        int tmp = A[l];
        A[l] = A[r];
        A[r] = tmp;
    }
}
