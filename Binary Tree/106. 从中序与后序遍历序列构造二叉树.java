import java.util.HashMap;
import java.util.Map;

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
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return generate(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode generate(int[] postorder, int left, int rigth, int start, int end) {
        if (left > rigth)
            return null;

        TreeNode root = new TreeNode(postorder[rigth]);

        int rootIndex = indexMap.get(postorder[rigth]);
        int leftNum = rootIndex - start;

        root.left = generate(postorder, left, left + leftNum - 1, start, rootIndex - 1);
        root.right = generate(postorder, left + leftNum, rigth - 1, rootIndex + 1, end);

        return root;
    }
}