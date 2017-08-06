package printFromTopToBottom;

/**
 * Created by Chen on 17-8-6
 * 第二种解法
 */

import java.util.ArrayList;
import java.util.Stack;

public class Solution2 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
        if (root == null) {
            return pathList;
        }
        Stack<Integer> stack = new Stack<>();
        FindPath(root, target, stack, pathList);
        return pathList;

    }

    private void FindPath(TreeNode root, int target, Stack<Integer> path, ArrayList<ArrayList<Integer>> pathList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i : path) {
                    list.add(new Integer(i));
                }
                list.add(new Integer(root.val));
                pathList.add(list);
            }
        } else {
            path.push(new Integer(root.val));
            FindPath(root.left, target - root.val, path, pathList);
            FindPath(root.right, target - root.val, path, pathList);
            path.pop();
        }

    }
}
