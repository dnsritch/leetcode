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
    Map<Integer, Integer> sumMap = new HashMap<>();
    int resSum = 0; // 结果总数
    int tempSum = 0; // 当前路径 sum

    public int pathSum(TreeNode root, int sum) {
        sumMap.put(0, 1);
        visit(root, sum);
        return resSum;
    }

    void visit(TreeNode node, int sum) {
        if (node != null) {
            tempSum += node.val;
            resSum += sumMap.getOrDefault(tempSum - sum, 0);
            sumMap.put(tempSum, sumMap.getOrDefault(tempSum, 0) + 1);

            visit(node.left, sum);
            visit(node.right, sum);

            sumMap.put(tempSum, sumMap.get(tempSum) - 1);
            tempSum -= node.val;
        }
    }
}