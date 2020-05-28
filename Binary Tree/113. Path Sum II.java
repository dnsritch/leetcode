import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
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

    List<List<Integer>> resList = new ArrayList<>();
    // Deque<TreeNode> stack = new LinkedList<>();
    List<Integer> stack = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        visit(root, sum);
        return resList;
    }

    void visit(TreeNode node, int sum) {
        if (node != null) {
            stack.add(node.val);
            if (node.left == null && node.right == null) {
                if (node.val == sum) {
                    resList.add(new ArrayList<>(stack));
                }
            } else {
                if (node.left != null)
                    visit(node.left, sum - node.val);
                if (node.right != null)
                    visit(node.right, sum - node.val);
            }
            stack.remove(stack.size() - 1);
        }
    }

    // 迭代
    // public List<List<Integer>> pathSum(TreeNode root, int sum) {
    // List<List<Integer>> resList = new ArrayList<>();
    // Deque<TreeNode> stack = new LinkedList<>();

    // TreeNode p = root;
    // int tempSum = 0;

    // while (p != null || !stack.isEmpty()) {
    // System.out.println("test");
    // while (p != null) {
    // tempSum += p.val;
    // stack.push(p);
    // p = p.left;
    // }
    // p = stack.pop();
    // if (p.right == null) {
    // if (tempSum == sum) {
    // List<Integer> list = new ArrayList<>();
    // for (TreeNode node : stack) {
    // list.add(node.val);
    // }
    // resList.add(list);
    // }
    // tempSum -= p.val;
    // }
    // p = p.right;
    // }
    // return resList;
    // }
}
