package VerifySequenceOfBST;

/**
 * Created by dell on 2017/8/5.
 * 22.输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出true,否则输出false。假设输入的数组的任意两个数字都互不相同
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int []sequence = {4,8,6,12,16,14,10};
        System.out.println(s.VerifySequenceOfBST(sequence));
    }
    public boolean VerifySequenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0){
            return false;
        }
        return isBST(sequence, 0, sequence.length - 1);
    }
    public boolean isBST(int []sequence, int start, int root) {
        if (start >= root) {
            return true;
        }
        int i = root;
        //从根结点开始找，直到小于根结点
        while (i > start && sequence[i - 1] > sequence[root]) {
            i--;
        }
        //如果前面有结点比根结点大，说明左子树结点大于根结点，则返回false
        for (int j = start; j < i - 1; j++) {
            if (sequence[j] > sequence[root]) {
                return false;
            }
        }
        return isBST(sequence, start, i - 1) && isBST(sequence, i, root - 1);
    }
}
