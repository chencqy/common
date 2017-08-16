package com.java.leetcode.hammingDistance;

/**
 * Created by Richard Chen on 17-8-16
 * description: 2.The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
                  Given two integers x and y, calculate the Hamming distance.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1,4));
    }

    /**
     * 求汉明距离，两个数字之间的汉明距离就是其二进制数对应位不同的个数
     * 我们可以一开始直接将两个数字异或起来，然后我们遍历异或结果的每一位，统计为1的个数
     */
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (xor >> i) & 1;
        }
        return count;
    }
}
