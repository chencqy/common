package com.java.jianzhioffer.isBalancedTree;

/**
 * Created by Richard Chen on 17-8-18
 * description: 39.输入一棵二叉树，判断该二叉树是否是平衡二叉树
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    /**
     * 后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次
     */
    private boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced = false;
        }
        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }
}
