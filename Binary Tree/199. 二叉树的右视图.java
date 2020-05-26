package Leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();

        if (root == null)
            return resList;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            int length = nodeQueue.size();
            for (int i = 0; i < length; i++) {
                TreeNode temp = nodeQueue.remove();
                if (i == length - 1) {
                    resList.add(temp.val);
                }

                if (temp.left != null) {
                    nodeQueue.add(temp.left);
                }
                if (temp.right != null) {
                    nodeQueue.add(temp.right);
                }

            }
        }
        return resList;
    }
}