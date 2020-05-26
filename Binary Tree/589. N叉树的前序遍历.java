import java.util.ArrayList;
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
    public List<Integer> preorder(Node root) {
        List<Integer> resList = new ArrayList<>();

        if (root == null)
            return resList;

        visit(root, resList);

        return resList;
    }

    void visit(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            for (int i = 0; i < node.children.size(); i++) {
                visit(node.children.get(i), list);
            }
        }
        return;
    }

}
// 改进迭代
// class Solution {
// public List<Integer> preorder(Node root) {
// List<Integer> resList = new ArrayList<>();

// if (root == null)
// return resList;

// Deque<Node> stack = new LinkedList<>();
// stack.push(root);

// while (!stack.isEmpty()) {
// Node p = stack.pop();
// resList.add(p.val);
// if (!p.children.isEmpty()) {
// for (int i = p.children.size() - 1; i >= 0; i--) {
// stack.push(p.children.get(i));
// }
// }
// }

// return resList;
// }

// }

// 垃圾迭代
// class Solution {
// public List<Integer> preorder(Node root) {
// List<Integer> resList = new ArrayList<>();

// if (root == null)
// return resList;

// Deque<Node> stack = new LinkedList<>();
// Deque<Integer> childIndex = new LinkedList<>();

// Node p = null;
// stack.push(root);
// childIndex.push(-1);

// while (!stack.isEmpty()) {
// p = stack.peek();

// if (childIndex.peek() != -1) { // 已访问
// int index = childIndex.peek();
// if (index < p.children.size() - 1) {// 存在未访问子节点
// stack.push(p.children.get(index + 1));
// childIndex.push(childIndex.pop() + 1);
// childIndex.push(-1);
// } else {// 所有子节点已访问
// stack.pop();
// childIndex.pop();
// }
// } else { // 未访问
// resList.add(p.val);
// if (!p.children.isEmpty()) { // 存在子节点
// stack.push(p.children.get(0));
// childIndex.push(childIndex.pop() + 1);
// childIndex.push(-1);
// } else {// 不存在子节点
// stack.pop();
// childIndex.pop();
// }
// }
// }

// return resList;
// }

// }