package fibonacci;

/**
 * Created by Richard Chen on 2017/5/17.
 * 9：斐波那契数列
 */
public class Solution {
    public int fibonacci(int n){
        int a = 1;
        int b = 1;
        int c = 0;
        if (n < 0){
            return 0;
        }else if (n == 1 || n == 2){
            return 1;
        }else {
            for(int i = 3; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
        }
        return c;
    }
}
