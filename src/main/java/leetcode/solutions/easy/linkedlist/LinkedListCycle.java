package leetcode.solutions.easy.linkedlist;

import leetcode.solutions.types.ListNode;

/**
 * Pattern: Linked List
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
