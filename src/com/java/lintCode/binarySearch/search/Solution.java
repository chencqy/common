package com.java.lintCode.binarySearch.search;

/**
 * Created by Richard Chen on 17-8-27
 * description: 3.8 :搜索旋转排序数组:
 * 假设有一个排序的按未知的旋转轴旋转的数组(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。给定一个目标值进行搜索，
 * 如果在数组中找到目标值返回数组中的索引位置，否则返回-1。
 * 你可以假设数组中不存在重复的元素。
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().search(new int[]{5}, 5);
    }

    /**
     * 用二叉查找的思想判断target属于左半数组还是右半数组。
     * 特别注意边界问题
     */
    public int search(int[] A, int target) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int low = 0;
        int high = A.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(A[mid] == target) {
                return mid;
            }
            if(A[mid] >= A[low]) {
                if(A[mid] > target && target >= A[low]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if(A[mid] < target && target <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return -1;
    }
}
