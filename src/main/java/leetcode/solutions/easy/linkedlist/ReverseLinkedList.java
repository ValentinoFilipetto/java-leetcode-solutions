package leetcode.solutions.easy.linkedlist;

import leetcode.solutions.types.ListNode;

/**
 * Pattern: Linked List
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}
