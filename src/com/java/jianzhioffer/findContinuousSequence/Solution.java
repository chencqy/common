package com.java.jianzhioffer.findContinuousSequence;

import java.util.ArrayList;

/**
 * Created by Richard Chen on 17-8-19
 * description: 41.和为sum的连续正数数列
 * 输出所有和为sum的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Solution {
    /**
     用两个数字small和big分别表示序列的最大值和最小值，
     首先将small初始化为1，big初始化为2.
     如果从small到big的和大于s，我们就从序列中去掉较小的值(即增大small),
     相反，只需要增大big。
     终止条件为：一直增加small到(1+sum)/2
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list;
        if (sum < 3) {
            return lists;
        }
        int small = 1;
        int big = 2;
        int curSum = small + big;
        int mid = (sum + 1) / 2;
        while (small < mid) {
            if (curSum == sum) {
                list = getList(small, big);
                lists.add(list);
            }
            while (curSum > sum && small < mid) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    list = getList(small, big);
                    lists.add(list);
                }
            }
            big++;
            curSum += big;
        }
        return lists;
    }
    private ArrayList<Integer> getList(int small, int big) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = small; i <= big; i++) {
            list.add(i);
        }
        return list;
    }
}
