import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class MinQueue<T> {
    int size = 0;
    Object head = null;
    Object end = null;
    List<T> list = new LinkedList<>();

    boolean add(T node) {
        list.add(node);
        return true;
    }

    T pop(){
        while()
    }

    T peek() {

    }

    MinQueue() {
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> indexList = new ArrayList<>();
        Arrays.asList(lists).forEach(head -> indexList.add(head));

        ListNode resListHead = new ListNode(0);
        ListNode listEnd = resListHead;

        while (checkList(indexList)) {
            int minIndex = findMin(indexList);
            System.out.println(minIndex);

            if (minIndex != -1) {
                ListNode minNode = indexList.get(minIndex);
                listEnd.next = minNode;
                indexList.set(minIndex, minNode.next);
                listEnd = listEnd.next;
            }
        }
        return resListHead.next;
    }

    public int findMin(List<ListNode> nodeList) {
        Integer minVal = null;
        int index = -1;

        for (int i = 0; i < nodeList.size(); i++) {
            ListNode node = nodeList.get(i);
            if (node != null) {
                if (minVal == null) {
                    minVal = node.val;
                    index = i;
                } else if (node.val < minVal) {
                    minVal = node.val;
                    index = i;
                }
            }
        }
        return index;
    }

    public boolean checkList(List<ListNode> nodeList) {
        boolean res = false;
        for (ListNode node : nodeList) {
            if (node != null) {
                res = true;
                break;
            }
        }
        return res;
    }
}
