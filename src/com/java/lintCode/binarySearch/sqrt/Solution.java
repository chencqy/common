package com.java.lintCode.binarySearch.sqrt;


/**
 * Created by Richard Chen on 17-8-26
 * description: 3. 1 : x的平方根
 *                    实现 int sqrt(int x) 函数，计算并返回 x 的平方根
 */
public class Solution {
    public int sqrt(int x) {
        int low = 0;
        int high = 46341;
        int mid = 0;
        while(low < high) {
            if (mid == (low + high) / 2) {
                break;
            }
            mid = (low + high) / 2;
            if(mid * mid == x) {
                return mid;
            } else if(mid * mid < x) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return mid;
    }
}
