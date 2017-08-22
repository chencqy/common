package com.java.lintCode.subarraySum;

import java.util.*;

/**
 * Created by Richard Chen on 17-8-22
 * description: 2.2:子数组之和：给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
 */
public class Solution {
    /**
     * 利用一个 map 记录从第一个元素开始到当前元素之和 与 当前元素的下标 的对应关系，若有一段子数组和为0，
     * 那么势必出现同一和对应2个下标，此时就找到了和为零的连续序列，时间复杂度是O(n)
     *
     * ps:我们从第一个开始，把对于每一个元素而言的前n项和求出来，当出现sum(j)=sum(i)(j>i)时，即可认为第i+1项到第j项的总和为0
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);//最初和为0，下标为-1
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.get(sum) != null) {//如果map中存在此sum说明序列为(map.get(sum) + 1,i)
                list.add(map.get(sum) + 1);
                list.add(i);
                return list;
            }
            map.put(sum,i);
        }
        return list;
    }
}
