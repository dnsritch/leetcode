import java.util.LinkedList;
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
// 深度优先
// class Solution {
// public int minDepth(TreeNode root) {
// if (root == null)
// return 0;

// int ml = minDepth(root.left);
// int mr = minDepth(root.right);

// return root.left == null || root.right == null ? ml + mr + 1 : Math.min(ml,
// mr) + 1;
// }
// }

// 广度优先
class Solution {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                TreeNode temp = queue.remove();

                if (temp.left == null && temp.right == null)
                    return depth;

                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return depth;
    }
}