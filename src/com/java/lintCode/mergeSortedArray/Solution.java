package com.java.lintCode.mergeSortedArray;

/**
 * Created by Richard Chen on 17-8-23
 * description:2.4 : 合并排序数组 II
 *                   合并两个排序的整数数组A和B变成一个新的数组。
 *                   样例:
                        给出 A = [1, 2, 3, empty, empty], B = [4, 5]
                        合并之后 A 将变成 [1,2,3,4,5]
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().mergeSortedArray(new int[]{1,2,3}, 3, new int[]{4,5}, 2);
    }
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int[] C = new int[m + n];
        int curA = 0;
        int curB = 0;
        while(curA < m && curB < n) {
            for(int i = 0; i < C.length; i++) {
                if (curA >= m || curB >= n) {
                    break;
                }
                if(A[curA] <= B[curB]) {
                    C[i] = A[curA];
                    curA++;
                }else{
                    C[i] = B[curB];
                    curB++;
                }
            }
        }
        int c = curA + curB;
        while(curA >= m && curB < n) {
            C[c] = B[curB];
            curB++;
            c++;
        }
        while(curB >= n && curA < m) {
            C[c] = A[curA];
            curA++;
            c++;
        }
        for(int i = 0; i < C.length; i++) {
            A[i] = C[i];
        }
    }
}
