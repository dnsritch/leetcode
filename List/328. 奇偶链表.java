/**
 * Definition for singly-linked list.
 */

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        // 奇数
        boolean flag = true;

        ListNode resOddList = new ListNode();
        ListNode resOddNode = resOddList;

        ListNode resEvenList = new ListNode();
        ListNode resEvenNode = resEvenList;

        while (head != null) {
            if (flag) {
                resOddNode.next = head;
                resOddNode = resOddNode.next;
            } else {
                resEvenNode.next = head;
                resEvenNode = resEvenNode.next;
            }
            head = head.next;
            flag = !flag;
        }
        resOddNode.next = null;
        resEvenNode.next = null;

        resOddNode.next = resEvenList.next;
        return resOddList.next;

    }
}