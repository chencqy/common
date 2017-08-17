package com.java.jianzhioffer.inversePairs;

/**
 * Created by Richard Chen on 17-8-17
 * description: 36.数组中的逆序对：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *                 输入一个数组,求出这个数组中的逆序对的总数.
 */
public class Solution {
    /**
     * 归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，
     合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面
     数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
     */
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count;

    }
    private int InversePairsCore(int[] array,int[] copy,int low,int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftCount = InversePairsCore(array, copy, 0, mid);
        int rightCount = InversePairsCore(array, copy, mid + 1, high);
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i > low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
            }else {
                copy[locCopy--] = array[j--];
            }
        }
        for(; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
        return (leftCount + rightCount + count);
    }
}
