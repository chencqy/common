package com.java.lintCode.greedyAlgorithm.canCompleteCircuit;

/**
 * Created by Richard Chen on 17-9-2
 * description: 5.3 : 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油gas[i]，并且从第_i_个加油站前往第_i_+1个加油站需要消耗汽油cost[i]。

 你有一辆油箱容量无限大的汽车，现在要从某一个加油站出发绕环路一周，一开始油箱为空。

 求可环绕环路一周时出发的加油站的编号，若不存在环绕一周的方案，则返回-1。
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int start = len -1;
        int end = 0;
        int sum = gas[start] - cost[start];
        while(start > end) {
            if(sum >= 0) {
                sum += gas[end] - cost[end];
                end++;
            } else {
                start--;
                sum += gas[start] - cost[start];
            }
        }
        return sum >= 0 ? start : -1;
    }
}
