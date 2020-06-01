import java.util.ArrayList;
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
    List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        visit(root, "");
        return list;
    }

    void visit(TreeNode node, String pre) {
        if (node != null) {

            pre += String.valueOf(node.val);
            if (node.left == null && node.right == null) {
                list.add(pre);
                return;
            }
            pre += "->";
            visit(node.left, pre);
            visit(node.right, pre);
        }
    }
}