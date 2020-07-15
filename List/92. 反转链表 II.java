/**
 * Definition for singly-linked list.
 */

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int index = 0;
        ListNode temp = new ListNode(0);
        ListNode tempHead = new ListNode(0);
        temp.next = head;
        head = temp;

        while (temp != null) {
            if ((index + 1) == m) {
                ListNode node = temp.next;
                ListNode lastNode = node;

                for (int i = 0; i <= n - m; i++) {
                    ListNode tempNode = tempHead.next;
                    tempHead.next = node;

                    node = node.next;

                    tempHead.next.next = tempNode;

                }

                lastNode.next = node;
                temp.next = tempHead.next;
                break;
            }
            index++;
            temp = temp.next;
        }

        return head.next;
    }
}
