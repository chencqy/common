package com.java.lintCode.firstMissingPositive;

/**
 * Created by Richard Chen on 17-8-24
 * description:2.7 :丢失的第一个正整数
 *                  给出一个无序的数组，找出其中没有出现的最小正整数。
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().firstMissingPositive(new int[]{2,1});
    }

    /**
     * （1） arr为整数1,2,3…N的一个随机排列，那个未出现的最小正整数就是N+1。
       （2） arr中有小于1或者大于N的数出现(我们称之为“不合法”的数)，
             则未出现的最小正整数一定在1到N中间（因为数组一共只有N个数，如果出现不合法的数，
             则出现的1到N之间的数的个数一定小于N，故一定有没有出现的数）。
     */
    public int firstMissingPositive(int[] A) {
        int low = 0;//low表示已经从1到low已经出现（左边界），low的初值为0。
        int len = A.length;//如果一个数字过大（不合法），就会被扔掉，用len表示这个右边界，len初始值为arr长度。
        while(low < len) {
            if((low + 1) == A[low]) {
                low++;
            }else if(A[low] <= low || A[low] > len || A[A[low] - 1] == A[low]) {
                //不合法的三种情况：1.小于等于左边界 2.大于右边界 3.在合适的位置上已经有了合适的数
                A[low] = A[len--];
            }else {
                //合法但是没有在理想的位置上
                //交换坐标low和A[low] - 1的两个数
                int temp = A[low];
                A[low] = A[A[low] - 1];
                A[temp - 1] = temp;
            }
        }
        return len + 1;
    }
}
