package com.java.lintCode.removeElement;


/**
 * Created by Richard Chen on 17-8-22
 * description: 2.1 : 删除元素
 *                     给定一个数组和一个值，在原地删除与值相同的数字，返回新数组的长度。
 *                     元素的顺序可以改变，并且对新的数组不会有影响
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A.length == 0 || A == null) {
            return 0;
        }
        if (A.length == 1) {
            if (A[0] == elem) {
                return 0;
            }else {
                return 1;
            }
        }
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            if (A[low] == elem) {
                if (A[high] != elem) {
                    swap(A, low, high);
                }else {
                    high--;
                }
            }else {
                low++;
            }
        }
        return low;
    }
    private void swap(int[] A, int low, int high) {
        int temp = A[low];
        A[low] = A[high];
        A[high] = temp;
    }
}
