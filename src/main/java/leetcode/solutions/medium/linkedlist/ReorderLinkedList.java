package leetcode.solutions.medium.linkedlist;

import leetcode.solutions.types.ListNode;

/**
 * Pattern: Linked List
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class ReorderLinkedList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 1. Find the middle point.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        // break the middle link
        slow.next = null;

        // 2. Reverse the second half.
        slow = null;
        while (secondHalf != null) {
            ListNode tmp = secondHalf.next;
            secondHalf.next = slow;
            slow = secondHalf;
            secondHalf = tmp;
        }

        ListNode firstHalf = head;
        secondHalf = slow;

        // 3. Merge first and reverse second half together, alternating nodes.
        while (secondHalf != null) {
            ListNode tmp1 = firstHalf.next;
            ListNode tmp2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = tmp1;
            firstHalf = tmp1;
            secondHalf = tmp2;
        }
    }
}
