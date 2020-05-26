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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        TreeNode p = root;
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                resList.add(p.val);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }

        return resList;
    }
}