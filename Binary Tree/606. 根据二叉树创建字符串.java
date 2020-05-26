import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
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
    // 迭代
    public String tree2str(TreeNode t) {
        StringBuilder res = new StringBuilder();
        if (t == null)
            return res.toString();

        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(t);
        TreeNode p = null;

        while (!stack.isEmpty()) {
            p = stack.peek();

            if (p == null) {
                stack.pop();
                stack.pop();
                res.append(")");
                continue;
            }

            res.append("(" + p.val);

            if (p.left != null || p.right != null) {

                stack.push(null);

                if (p.left == null && p.right != null)
                    res.append("()");

                if (p.right != null)
                    stack.push(p.right);

                if (p.left != null)
                    stack.push(p.left);

            } else {
                stack.pop();
                res.append(")");
            }

        }

        return res.substring(1, res.length() - 1);
    }

    // 递归
    // public String tree2str(TreeNode t) {

    // if (t == null)
    // return "";
    // if (t.left == null && t.right == null)
    // return t.val + "";
    // if (t.right == null)
    // return t.val + "(" + tree2str(t.left) + " )";

    // return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    // }

}