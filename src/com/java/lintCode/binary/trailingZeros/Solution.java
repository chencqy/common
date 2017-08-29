package com.java.lintCode.binary.trailingZeros;

/**
 * Created by Richard Chen on 17-8-29
 * description: 4.3:尾部的零 : 设计一个算法，计算出n阶乘中尾部零的个数
 */
public class Solution {
    public long trailingZeros(long n) {
        long count = 0;
        long temp = n / 5;
        while (temp != 0) {
            count += temp;
            temp /= 5;
        }
        return count;
    }
}
