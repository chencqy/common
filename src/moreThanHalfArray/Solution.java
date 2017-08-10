package moreThanHalfArray;

/**
 * Created by Richard Chen on 2017/8/10.
 * description: 27.数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        if (array == null || length == 0) {
            return 0;
        }
        int result = array[0];

        /**
         * 用times来记录，从第一个元素开始，遇到相同的元素则times加1，不相同的减1;如果为0说明这个元素不可能是我们要的元素，于是指定
         * 下一个元素，如果循环完毕times还不为0说明这个元素有可能就是数组中出现次数最多的元素。
         * 再做一个for循环检查其次数是否大于数组长度的一半。
         */
        int times = 1;
        for (int i = 0; i < length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            }else {
                if (result == array[i]){
                    times++;
                }else {
                    times--;
                }
            }
        }
        times = 0;
        for (int i = 0; i < length; i++) {
            if (result == array[i]) {
                times++;
            }
        }
        if (times * 2 <= length){
            return 0;
        }
        return result;

    }
}
