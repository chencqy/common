package com.java.lintCode.binarySearch.findPeak;

/**
 * Created by Richard Chen on 17-8-27
 * description: 3.6 : 寻找峰值
 * 你给出一个整数数组(size为n)，其具有以下特点：

 相邻位置的数字是不同的
 A[0] < A[1] 并且 A[n - 2] > A[n - 1]
 假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
 */
public class Solution {
    public int findPeak(int[] A) {
        int low = 1;
        int high = A.length - 2;
        while(low <= high) {
            if(A[low] > A[low + 1]) {
                return low;
            } else if(A[high] > A[high - 1]) {
                return high;
            } else {
                low = low + 1;
                high = high - 1;
            }
        }
        return -1;
    }
}
