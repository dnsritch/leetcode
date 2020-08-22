/**
 * Definition for singly-linked list.

 */
class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = val === undefined ? 0 : val
        this.next = next === undefined ? null : next
    }
}

function removeNthFromEnd(head: ListNode | null, n: number): ListNode | null {
    let index = 0
    let headNode = new ListNode()

    headNode.next = head
    head = headNode

    let slowPoint: ListNode | null = headNode

    while (head.next) {
        index++
        head = head.next
        if (index > n) {
            slowPoint && (slowPoint = slowPoint.next)
        }
    }
    if (slowPoint) {
        slowPoint.next = slowPoint.next ? slowPoint.next.next : null
    }

    return headNode.next
}
