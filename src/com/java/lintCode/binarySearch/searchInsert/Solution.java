package com.java.lintCode.binarySearch.searchInsert;

/**
 * Created by Richard Chen on 17-8-26
 * description: 3.2 : 搜索插入位置 :
 *                    给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。
 *                    如果没有，返回到它将会被按顺序插入的位置。
 *                    你可以假设在数组中无重复元素。
 */
public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int low = 0;
        int high = A.length;
        int mid = 0;
        while(low < high) {
            if(mid == (low + high) / 2) {
                break;
            }
            mid = (low + high) / 2;
            if(A[mid] == target) {
                return mid;
            } else if(A[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if(A[mid] < target) {
            return (mid + 1);
        }
        return mid;
    }
}
