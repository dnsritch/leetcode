import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.ls.LSInput;

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
    Map<Integer, Integer> countMap = new HashMap<>();
    int maxCount = 0;
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        visit(root);
        int[] res = new int[list.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    void visit(TreeNode root) {
        if (root != null) {
            visit(root.left);

            int count = countMap.getOrDefault(root.val, 0) + 1;
            countMap.put(root.val, count);

            if (count > maxCount) {
                maxCount = count;
                list.clear();
                list.add(root.val);
            } else if (count == maxCount) {
                list.add(root.val);
            } else {

            }

            visit(root.right);
        }
    }
}