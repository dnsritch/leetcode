import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
    /**
     * 使用标记栈
     */
    // public List<Integer> preorderTraversal(TreeNode root) {
    // List<Integer> resList = new ArrayList<>();

    // Deque<TreeNode> stack = new LinkedList<>();
    // Deque<Boolean> flagList = new LinkedList<>();

    // TreeNode p = root;
    // boolean flag = false;

    // while (!stack.isEmpty() || p != null) {
    // while (p != null) {
    // stack.push(p);
    // flagList.push(false);
    // p = p.left;
    // }
    // p = stack.pop();
    // flag = flagList.pop();

    // if (flag) {
    // resList.add(p.val);
    // p = null;
    // } else {
    // stack.push(p);
    // flagList.push(true);
    // p = p.right;
    // }
    // }
    // return resList;
    // }

    /**
     * 只使用一个栈 不使用标记栈
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null)
            return resList;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = null;
        stack.push(root);

        while (!stack.isEmpty()) {
            p = stack.peek();
            if (p == null) {
                stack.pop();
                p = stack.pop();
                resList.add(p.val);
                continue;
            }
            stack.push(null);
            if (p.right != null)
                stack.push(p.right);
            if (p.left != null)
                stack.push(p.left);
        }

        return resList;
    }

}