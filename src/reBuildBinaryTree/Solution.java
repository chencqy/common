package reBuildBinaryTree;

/**
 * Created by Richard Chen on 2017/5/11.
 * 面试题6：重建二叉树
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in){
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int [] pre, int startPre, int endPre, int [] in, int startIn, int endIn){
        if (startPre > endPre || startIn > endIn){
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++){
            if (pre[startPre] == in[i]){
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + i -startIn +1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }

}
