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

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        merger(t1, null, t2, null);
        return t1;
    }

    void merger(TreeNode t1, TreeNode t1pre, TreeNode t2, TreeNode t2pre) {
        if (t1 != null && t2 != null) {
            t1.val = t1.val + t2.val;
            merger(t1.left, t1, t2.left, t2);
            merger(t1.right, t1, t2.right, t2);
        } else if (t1 == null && t2 != null) {
            if (t2 == t2pre.left) {
                t1pre.left = t2pre.left;
                t2pre.left = null;
            } else {
                t1pre.right = t2pre.right;
                t2pre.right = null;
            }
        } else {

        }
    }
}