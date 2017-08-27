package com.java.lintCode.binarySearch.findPeak;

/**
 * Created by Richard Chen on 17-8-27
 * description:3.6 : 寻找峰值 : 利用二分查找优化
 */
public class Solution2 {
    /**
     * mid元素所处位置有四种情况：
     a.mid就是峰值元素。
     b.mid为低点，则mid前部分必然存在峰值元素。
     c.mid位于一段单调递减区间内，则mid前部分也然存在峰值元素。
     d.mid位于一段单调递增区间内，则mid后部分必然存在峰值元素。
     */
    public int findPeak(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while(low < high) {
            int mid = (low + high) / 2;
            if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if(A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
                high = mid;
            } else if(A[mid] < A[mid - 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
