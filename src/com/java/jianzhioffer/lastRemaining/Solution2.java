package com.java.jianzhioffer.lastRemaining;

/**
 * Created by Richard Chen on 17-8-21
 * description:45.圆圈中最后剩下的数字
 *             第二种解法：用数组来模拟环
 */
public class Solution2 {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] array = new int[n];
        int step = 0;
        int count = n;
        int i = -1;
        while (count > 0) {
            i++;
            if (i >= n) {
                i = 0;
            }
            if (array[i] == -1) {
                continue;
            }
            step++;//记录已走过的。
            if (step == m) {//找到待删除的对象。
                array[i] = -1;
                step = 0;
                count--;
            }
        }
        return i;//返回跳出循环时的i,即最后一个被设置为-1的元素
    }
}
