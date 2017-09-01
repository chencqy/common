package com.java.lintCode.greedyAlgorithm.majorityNumber;

import java.util.List;

/**
 * Created by Richard Chen on 17-9-01
 * description: 5.2 : 主元素
 * 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 */
public class Solution {
    /**
     * 充分利用已知条件出现次数大于N/2。首先假设主元素是X，则遍历数组时出现与X相等的元素时，X出现的数目+1，
     * 不相等时，如果计数值变为1，则这个X可能不是主元素，需要将假定值更改为新出现的元素，计数值不为1时，
     * 则X出现的数目-1.遍历完后的X就是主元素。复杂度为O(n)
     */
    public int majorityNumber(List<Integer> nums) {
        int result;
        int count = 0;
        result = nums.get(0);
        for(int i = 0; i < nums.size(); i++) {
            if(result == nums.get(i)) {
                count++;
            } else if(count == 1) {
                result = nums.get(i);
            } else {
                count--;
            }
        }
        return result;
    }
}
