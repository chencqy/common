package com.java.lintCode.binary.numTrees;

/**
 * Created by Richard Chen on 17-8-30
 * description: 4.5 :不同的二叉查找树
 * 给出 n，问由 1...n 为节点组成的不同的二叉查找树有多少种？
 */
public class Solution {
    /**
     * 使用卡特兰数，另外使用动态规划，使用一维数组 dp[i] 保存由 i 个节点组成的不同的二叉查找树的种类
     卡特兰数的递推公式为：
     f(n) = f(n-1)f(0) + f(n-2)f(1) + f(n-3)f(2) + ... + f(1)f(n-2) + f(n-1)f(0)
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        if(n == 0 || n == 1) {
            return 1;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
