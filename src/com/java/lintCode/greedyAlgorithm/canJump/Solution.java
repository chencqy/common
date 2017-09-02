package com.java.lintCode.greedyAlgorithm.canJump;

/**
 * Created by Richard Chen on 17-9-2
 * description: 5.6 : 跳跃游戏
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。　　　

 数组中的每个元素代表你在那个位置可以跳跃的最大长度。　　　　

 判断你是否能到达数组的最后一个位置。
 */
public class Solution {
    public boolean canJump(int[] A) {
        int max = 0;
        for(int i = 0; i < A.length; i++) {
            if(i > max) return false;
            max = Math.max(i + A[i], max);
        }
        return true;
    }
}
