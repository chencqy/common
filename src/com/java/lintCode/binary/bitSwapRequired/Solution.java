package com.java.lintCode.binary.bitSwapRequired;

/**
 * Created by Richard Chen on 17-8-29
 * description: 4.1 : 将整数A转换为B: 如果要将整数A转换为B，需要改变多少个bit位？
 */
public class Solution {
    /**
     * 这题的意思就是比较A和B中不同位的个数及相异位的个数。因此，很容易想到异或操作，及相异为1,相同为0。
     * 因此可以先做C = A^B，然后在计算C的二进制表示中1的个数。
     */
    public static int bitSwapRequired(int a, int b) {
        int m = a ^ b;
        int count = 0;
        for (int i = 0; i < 32; ++i) {
            if ((m & 1) == 1) {
                count++;
            }
            m >>= 1;
        }
        return count;
    }
}
