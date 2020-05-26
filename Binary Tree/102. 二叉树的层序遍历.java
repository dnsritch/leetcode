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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> list = new ArrayList<>();

            while (length-- > 0) {
                TreeNode temp = queue.remove();
                list.add(temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }

            resList.add(list);
        }

        return resList;

    }
}