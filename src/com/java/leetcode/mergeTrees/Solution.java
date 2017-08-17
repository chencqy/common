package com.java.leetcode.mergeTrees;

/**
 * Created by Richard Chen on 17-8-17
 * description: 3.Given two binary trees and imagine that when you put one of them to cover the other,
 *                some nodes of the two trees are overlapped while the others are not.

                  You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
                  then sum node values up as the new value of the merged node. Otherwise,
                  the NOT null node will be used as the node of new tree.
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    /**
     * 合并二叉树
     *  合并规则是如果两个节点重叠，则sum节点值作为合并节点的新值。 否则，空节点将被用作新树的节点。
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);
        newNode.left = mergeTrees((t1 == null ? null : t1.left), (t2 == null ? null : t2.left));
        newNode.right = mergeTrees((t1 == null ? null : t1.right), (t2 == null ? null : t2.right));
        return newNode;
    }
}
