package leetcode.solutions.medium.linkedlist;

import leetcode.solutions.types.ListNode;

/**
 * Pattern: Linked List (Math)
 * Time complexity: O(m + n) where m and n are the lengths of the two linked lists.
 * Space complexity: O(max(m, n)) for the output list;
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(0);
        ListNode dummy = curr;

        int carry = 0;
        while (l1 != null || l2 != null) {
            // It could be that one list/number is longer than the other.
            // We make sure we have a default value.
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int val3 = val1 + val2 + carry;

            // Should we carry something ahead?
            carry = val3 > 9 ? 1 : 0;

            curr.next = new ListNode(val3 % 10);
            curr = curr.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        // Remember to check if there is one last carry to add.
        curr.next = carry > 0 ? new ListNode(1) : null;
        return dummy.next;
    }
}
