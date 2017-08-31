package com.java.lintCode.greedyAlgorithm.singleNumber;

/**
 * Created by Richard Chen on 17-8-31
 * description: 5.1 : 落单的数
 * 给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 */
public class Solution {
    /**
     * 通过异或，相同的数结果为0，那么最后的结果一定是落单的数字。
     */
    public int singleNumber(int[] A) {
        int a = 0;
        for(int i = 0; i < A.length; i++) {
            a ^= A[i];
        }
        return a;
    }
}
