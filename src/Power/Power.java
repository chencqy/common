package Power;

/**
 * Created by Richard Chen on 2017/7/20.
 * 11.数值的整数次方
 */
public class Power {
    public double power(int base, int exponent){
        int n = Math.abs(exponent);
        //如果n为0
        if (n == 0){
            return 1;
        }
        //如果n为1
        if (n == 1) {
            return base;
        }
        /**
         * 递归 :n为偶数，a^n=a^n/2*a^n/2;
         *      n为奇数，a^n=（a^（n-1）/2）*（a^（n-1/2））*a
         时间复杂度O（logn）
         */
        //n右移一位
        double result = power(base, n >> 1);
        result *= result;
        //如果n为奇数
        if ((n & 1) == 1){
            result *= base;
        }
        //指数小于0取倒数
        if (exponent < 0){
            return 1.0/result;
        }
        return result;
    }
}
