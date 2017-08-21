package com.java.jianzhioffer.lastRemaining;

/**
 * Created by Richard Chen on 17-8-21
 * description: 45.圆圈中最后剩下的数字 : 0 , 1 ,2 ...n-1, n这n个数字排成一个圆圈，从数字0开始每次从圆圈里删除第m个数字
 *                求出这个圆圈里剩下的最后一个数字
 */
public class Solution {
    /**
     * 把n个人的编号改为0~n-1，然后对删除的过程进行分析。
     第一个删除的数字是(m-1)%n，几位k，则剩余的编号为(0,1,...,k-1,k+1,...,n-1)，下次开始删除时，顺序为(k+1,...,n-1,0,1,...k-1)。
     用f(n,m)表示从(0~n-1)开始删除后的最终结果。
     用q(n-1,m)表示从(k+1,...,n-1,0,1,...k-1)开始删除后的最终结果。
     则f(n,m)=q(n-1,m)。

     下面把(k+1,...,n-1,0,1,...k-1)转换为(0~n-2)的形式，即
     k+1对应0
     k+2对于1
     ...
     k-1对应n-2
     转化函数设为p(x)=(x-k-1)%n, p(x)的你函数为p^(x)=(x+k+1)%n。
     则f(n,m)=q(n-1,m)=p^(f(n-1,m))=(f(n-1,m)+k+1)%n，又因为k=(m-1)%n。
     f(n,m)=(f(n-1,m)+m)%n;

     最终的递推关系式为
     f(1,m) = 0;                        (n=1)
     f(n,m)=(f(n-1,m)+m)%n; （n>1）
     */
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for(int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
