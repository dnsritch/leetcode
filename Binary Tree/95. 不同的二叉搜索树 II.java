import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return subTree(1, n);
    }

    List<TreeNode> subTree(int left, int right) {
        List<TreeNode> resList = new LinkedList<>();
        if (left > right) {
            resList.add(null);
            return resList;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftList = subTree(left, i - 1);
            List<TreeNode> rightList = subTree(i + 1, right);

            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    TreeNode node = new TreeNode(i);

                    node.left = leftNode;
                    node.right = rightNode;

                    resList.add(node);

                }
            }
        }

        return resList;
    }
}