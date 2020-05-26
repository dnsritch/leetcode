import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
// Definition for a Node.
*/

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> resList = new LinkedList<>();
        Deque<Node> stack = new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node p = stack.pop();
            if (p != null) {
                resList.add(0, p.val);
                int len = p.children.size();
                for (int i = 0; i < len; i++) {
                    stack.push(p.children.get(i));
                }
            }
        }
        return resList;
    }
}

// 递归
// class Solution {
// public List<Integer> postorder(Node root) {

// List<Integer> resList = new ArrayList<>();

// visit(root, resList);

// return resList;
// }

// void visit(Node p, List<Integer> list) {
// if (p != null) {
// for (int i = 0; i < p.children.size(); i++) {
// visit(p.children.get(i), list);
// }
// list.add(p.val);
// }
// }
// }

// 先序输出 再倒序
// class Solution {
// public List<Integer> postorder(Node root) {
// List<Integer> resList = new ArrayList<>();
// Deque<Node> stack = new LinkedList<>();

// stack.push(root);

// while (!stack.isEmpty()) {
// Node p = stack.pop();
// if (p != null) {
// resList.add(p.val);
// for (Node node : p.children) {
// stack.push(node);
// }
// }
// }
// Collections.reverse(resList);
// return resList;
// }
// }