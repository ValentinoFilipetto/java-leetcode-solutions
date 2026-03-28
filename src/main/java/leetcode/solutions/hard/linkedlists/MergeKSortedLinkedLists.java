package leetcode.solutions.hard.linkedlists;

import leetcode.solutions.types.ListNode;

/**
 * Pattern: Linked List
 * Time complexity: O(n * k), where n is the average length of the lists and k is the number of lists.
 * Space complexity: O(1)
 */

public class MergeKSortedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (true) {
            int minNodeIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }

                if (minNodeIndex == -1 || lists[i].val < lists[minNodeIndex].val) {
                    minNodeIndex = i;
                }
            }
            
            // Break because all linked lists are empty or we reached the end of all linked lists.
            if (minNodeIndex == -1) {
                break;
            }
            
            // We reuse the already existing nodes.
            curr.next = lists[minNodeIndex];
            lists[minNodeIndex] = lists[minNodeIndex].next;
            curr = curr.next;
        }
        return dummy.next;
    }
}