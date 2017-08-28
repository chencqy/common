package com.java.lintCode.binarySearch.woodCut;

/**
 * Created by Richard Chen on 17-8-28
 * description: 3.10 : 木材加工
 * 有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。
 * 当然，我们希望得到的小段越长越好，你需要计算能够得到的小段木头的最大长度。

 注意事项:
 木头长度的单位是厘米。原木的长度都是正整数，我们要求切割得到的小段木头的长度也要求是整数。
 无法切出要求至少 k 段的,则返回 0 即可。
 */
public class Solution {
    /**
     * 要达到n*log Len ,可以想到的是用折半查找。需要注意的是不一定要将所有的木头都切了，过短的木头可以不切。
     * 第一次遍历数组，求和并求得最大值。若和小于k，则返回0.接下来在1—max之间用二分查找，找到最大的长度。
     */
    public int woodCut(int[] L, int k) {
        if (L.length == 0) {
            return 0;
        }
        long sum = L[0];
        long max = L[0];

        for (int i=1;i<L.length;i++) {
            sum += L[i];
            max = Math.max(L[i],max);
        }
        if (sum < k) {
            return 0;
        }

        long i = 1;
        long j = max;

        while(i <= j) {
            long mid = (i + j) / 2;
            if (judge(L,k,mid)) {
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }
        return (int)j;
    }

    public boolean judge(int[] L,int k,long l){
        int num = 0;
        for (int x : L) {
            num += x/l;
        }
        if (num >= k) {
            return true;
        }
        return false;
    }
}
