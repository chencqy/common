package com.java.lintCode.binarySearch.findFirstBadVersion;

/**
 * Created by Richard Chen on 17-8-27
 * description: 3.7 : 第一个错误的代码版本
 * 代码库的版本号是从 1 到 n 的整数。某一天，有人提交了错误版本的代码，因此造成自身及之后版本的代码在单元测试中均出错。
 * 请找出第一个错误的版本号。
   你可以通过 isBadVersion 的接口来判断版本号 version 是否在单元测试中出错，具体接口详情和调用方法请见代码的注释部分。
 */


class SVNRepo {
    public static boolean isBadVersion(int k) {
        return false;
    }
}

public class Solution {
    public int findFirstBadVersion(int n) {
        int low = 1;
        int high = n;
        int mid = 0;
        while(low < high) {
            mid = low + (high - low) / 2;
            if(SVNRepo.isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
