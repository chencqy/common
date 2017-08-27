package com.java.lintCode.binarySearch.searchRange;

/**
 * Created by Richard Chen on 17-8-27
 * description: 3.9 : 搜索区间 :
 * 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
   如果目标值不在数组中，则返回[-1, -1]
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().searchRange(new int[]{9,10,100,101,1002,10203}, 10203);
    }

    /**
     * 二分法分别找左右边界
     */
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1,-1};
        int len = A.length;
        if(len == 0 || A == null)
            return res;
        res[0] = BinaryLeft(A,0,len-1,target);
        res[1] = BinaryRight(A,0,len-1,target);
        return res;
    }
    public int BinaryLeft(int[] nums,int left,int right,int target){
        if(nums[0] == target)
            return 0;
        while(left <= right){
            int median = (left + right)/2;
            if(nums[median] < target){
                left = median+1;
            }else if(nums[median] > target){
                right = median -1;
            }else if(nums[median] == target){
                if(nums[median-1] != target)
                    return median;
                else
                    right = median - 1;
            }
        }
        return -1;
    }

    public int BinaryRight(int[] nums,int left,int right,int target){
        if(nums[right] == target)
            return right;
        while(left <= right){
            int median = (left + right)/2;
            if(nums[median] < target){
                left = median+1;
            }else if(nums[median] > target){
                right = median -1;
            }else if(nums[median] == target){
                if(nums[median+1] != target)
                    return median;
                else
                    left = median + 1;
            }
        }
        return -1;
    }
}
