package leetcode.solutions.medium.linkedlist;

import leetcode.solutions.types.ListNode;

/**
 * Pattern: Linked List (Two Pointers)
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class RemoveNodeFromEndOfLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;

        // Move first pointer n nodes to the right to create a gap of n nodes
        // between first and second pointer.
        while (n > 0) {
            first = first.next;
            n--;
        }

        // Advance first and second pointers together with the same pace.
        // Since first was *before* head at the beginning, it will end up right *before* the node to be removed.
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove node.
        second.next = second.next.next;
        return dummy.next;
    }
}
