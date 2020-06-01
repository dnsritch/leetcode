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
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    int sum(TreeNode node, int pre) {

        if (node != null) {
            pre = pre * 10 + node.val;

            if (node.left != null && node.right != null) {
                return sum(node.left, pre) + sum(node.right, pre);
            } else if (node.left != null) {
                return sum(node.left, pre);
            } else {
                return sum(node.right, pre);
            }
        }
        return pre;
    }
}