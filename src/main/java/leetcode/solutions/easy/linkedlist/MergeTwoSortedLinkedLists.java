package leetcode.solutions.easy.linkedlist;

import leetcode.solutions.types.ListNode;

public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode mergedList = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                // Always assign the new node to the `next` of the current list!
                mergedList.next = list1;
                list1 = list1.next;
            } else {
                mergedList.next = list2;
                list2 = list2.next;
            }
            mergedList = mergedList.next;
        }

        // No need to check that list1 or list2 are null here,
        // as otherwise we would not end up here from the while loop above.
        if (list1 != null) {
            mergedList.next = list1;
        } else if (list2 != null) {
            mergedList.next = list2;
        }

        return dummyNode.next;
    }
}
