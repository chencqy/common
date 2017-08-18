package com.java.jianzhioffer.getNumberOfK;

/**
 * Created by Richard Chen on 17-8-18
 * description: 38.统计一个数字在排序数组中出现的次数
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().GetNumberOfK(new int[]{1,2,3,3,3,3}, 3));
    }

    /**
     * 二分查找 找到第一个K 和 最后一个K 二者位置相减
     */
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int number = 0;
        int length = array.length;
        int firstK = GetFirstK(array, length, k, 0, length - 1);
        int lastK = GetLastK(array, length, k, 0, length - 1);
        if (firstK > -1 && lastK > -1) {
            number = lastK - firstK + 1;
        }
        return number;
    }
    private int GetFirstK(int[] array, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int dataMidIndex = array[midIndex];
        if (dataMidIndex == k) {
            if ((midIndex > 0 && array[midIndex - 1] != k) || midIndex == 0) {
                return midIndex;
            }else {
                end = midIndex - 1;
            }
        }else if (dataMidIndex > k) {
            end = midIndex - 1;
        }else {
            start = midIndex + 1;
        }
        return GetFirstK(array, length, k, start, end);
    }
    private int GetLastK(int[] array, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int dataMidIndex = array[midIndex];
        if (dataMidIndex == k) {
            if ((midIndex < (length - 1) && array[midIndex + 1] != k) || midIndex == (length - 1)) {
                return midIndex;
            }else {
                start = midIndex + 1;
            }
        }else if (dataMidIndex > k) {
            end = midIndex - 1;
        }else {
            start = midIndex + 1;
        }
        return GetLastK(array, length, k, start, end);
    }
}
