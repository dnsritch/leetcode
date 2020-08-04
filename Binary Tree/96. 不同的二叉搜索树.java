import java.util.ArrayList;
import java.util.List;

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
    int[] cache;

    public int numTrees(int n) {
        cache = new int[n + 1];
        return subTree(n);
    }

    int subTree(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + subTree(i) * subTree(n - i - 1);
        }
        cache[n] = sum;
        return sum;
    }
}