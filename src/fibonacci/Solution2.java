package fibonacci;

/**
 * Created by Richard Chen on 2017/5/17.
 * 面试题9题目二：青蛙跳台阶
 */
public class Solution2 {
    public int JumpFloor(int target) {
        int a = 1;
        int b = 2;
        int c = 0;
        if(target < 0){
            return 0;
        }else if(target == 1 || target == 2){
            return target;
        }else{
            for(int i = 3; i <= target; i++){
                c = a + b;
                a = b;
                b = c;
            }
        }
        return c;

    }
}
