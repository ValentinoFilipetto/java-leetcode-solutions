package leetcode.solutions.medium.linkedlist;

import leetcode.solutions.types.ListNodeWithRandomPointer;
import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListWithRandomPointer {
    public ListNodeWithRandomPointer copyRandomList(ListNodeWithRandomPointer head) {
        Map<ListNodeWithRandomPointer, ListNodeWithRandomPointer> originalToCopy = new HashMap<>();

        // Store clones of nodes in HashMap without any links.
        ListNodeWithRandomPointer curr = head;
        while (curr != null) {
            ListNodeWithRandomPointer copy = new ListNodeWithRandomPointer(curr.val);
            originalToCopy.put(curr, copy);
            curr = curr.next;
        }

        // Create links in new linked list based on old linked list.
        curr = head;
        while (curr != null) {
            originalToCopy.get(curr).next = originalToCopy.getOrDefault(curr.next, null);
            originalToCopy.get(curr).random = originalToCopy.getOrDefault(curr.random, null);
            curr = curr.next;
        }
        return originalToCopy.get(head);
    }
}
