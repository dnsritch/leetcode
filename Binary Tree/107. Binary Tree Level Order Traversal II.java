import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> resList = new ArrayList<>();

        if (root == null) {
            return resList;
        }

        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);

        while (!treeQueue.isEmpty()) {

            int length = treeQueue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                TreeNode temp = treeQueue.poll();
                list.add(temp.val);

                if (temp.left != null) {
                    treeQueue.add(temp.left);
                }
                if (temp.right != null) {
                    treeQueue.add(temp.right);
                }

            }
            resList.add(0, list);
        }
        return resList;
    }
}