package com.java.lintCode.binaryTree.insertNode;

/**
 * Created by Richard Chen on 17-9-11
 * description: 7.3 : 在二叉查找树中插入节点
 * 给定一棵二叉查找树和一个新的树节点，将节点插入到树中。

 你需要保证该树仍然是一棵二叉查找树。
 */

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Soluiton {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if(root == null) {
            return node;
        }
        if(node.val > root.val) {
            if(root.right == null) {
                root.right = node;
            } else {
                insertNode(root.right, node);
            }
        } else if(node.val < root.val) {
            if(root.left == null) {
                root.left = node;
            } else {
                insertNode(root.left, node);
            }
        }
        return root;
    }
}
