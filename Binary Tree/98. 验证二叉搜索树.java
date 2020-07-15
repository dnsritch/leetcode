import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * 
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    Integer pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        if (!isValidBST(root.left))
            return false;

        if (pre != null && root.val <= pre)
            return false;

        pre = root.val;

        if (!isValidBST(root.right))
            return false;

        return true;
    }

    public boolean isValidBST0(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // 迭代
    boolean checkNode(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        Integer pre = null;

        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();

            if (pre != null && p.val <= pre)
                return false;

            pre = p.val;

            p = p.right;
        }

        return true;
    }

    // 递归
    boolean check(TreeNode root, Integer lower, Integer uper) {

        if (root == null)
            return true;

        int val = root.val;
        if (val <= lower || val >= uper)
            return false;

        if (!check(root.left, lower, val))
            return false;
        if (!check(root.right, val, uper))
            return false;

        return true;
    }

}