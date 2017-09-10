package com.java.lintCode.binaryTree.isBalanced;

/**
 * Created by Richard Chen on 17-9-10
 * description: 7.1 : 平衡二叉树
 * 给定一个二叉树,确定它是高度平衡的。对于这个问题,一棵高度平衡的二叉树的定义是：
 * 一棵二叉树中每个节点的两个子树的深度相差不会超过1
 */

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Solution {
    static boolean balance = true;
    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return balance;

    }
    private int getDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(Math.abs(left - right) > 1) {
            balance = false;
        }
        return left > right ? (left + 1) : (right + 1);

    }
}
