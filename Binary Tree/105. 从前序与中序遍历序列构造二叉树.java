import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
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
    // 递归
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return generate(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode generate(int[] preorder, int start, int end, int left, int right) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);

        int rootIndex = inorderMap.get(preorder[start]);

        int leftNum = rootIndex - left;
        int rightNum = right - rootIndex;

        root.left = generate(preorder, start + 1, start + leftNum, left, rootIndex - 1);
        root.right = generate(preorder, start + leftNum + 1, end, rootIndex + 1, right);

        return root;
    }

    // 迭代
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    // if (preorder == null || preorder.length == 0)
    // return null;

    // Deque<TreeNode> stack = new LinkedList<>();
    // TreeNode root = new TreeNode(preorder[0]);
    // stack.push(root);
    // int index = 0;

    // for (int i = 1; i < preorder.length; i++) {
    // TreeNode node = stack.peek();

    // if (node.val != inorder[index]) {
    // node.left = new TreeNode(preorder[i]);
    // stack.push(node.left);
    // } else {
    // while (!stack.isEmpty() && stack.peek().val == inorder[index]) {
    // node = stack.pop();
    // index++;
    // }
    // node.right = new TreeNode(preorder[i]);
    // stack.push(node.right);
    // }
    // }

    // return root;
    // }
}