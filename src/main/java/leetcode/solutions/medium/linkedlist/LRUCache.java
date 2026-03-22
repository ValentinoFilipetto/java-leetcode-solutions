package leetcode.solutions.medium.linkedlist;

import java.util.HashMap;
import java.util.Map;
import leetcode.solutions.types.DoublyLinkedListNode;

/**
 * Pattern: Doubly Linked List
 * Time complexity: O(1) for get and put operations
 * Space complexity: O(n)
 * Intuition: Use a doubly linked list to maintain the order of usage and 
 * a hash map to store the key and corresponding node for O(1) access.
 */

class LRUCache {
    int capacity;
    int size = 0;
    // Map to store key and corresponding node in the doubly linked list.
    Map<Integer, DoublyLinkedListNode> map = new HashMap<>();
    DoublyLinkedListNode left;  // LRU
    DoublyLinkedListNode right; // MRU

    public LRUCache(int capacity) {
        this.capacity = capacity;
        left = new DoublyLinkedListNode(0, 0);
        right = new DoublyLinkedListNode(0, 0);
        left.next = right;
        right.prev = left;
    }

    // Remove node from the list.
    private void removeNode(DoublyLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Append node to the right (MRU) end of the list.
    private void appendRight(DoublyLinkedListNode node) {
        DoublyLinkedListNode prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }

    // Get the value of the key if it exists, otherwise return -1.
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        DoublyLinkedListNode node = map.get(key);
        removeNode(node);
        appendRight(node);

        return node.value;
    }

    // Update the value of the key if it exists, otherwise add the key-value pair to the cache
    // If the cache exceeds its capacity, remove the least recently used key.
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoublyLinkedListNode node = map.get(key);
            node.value = value;
            removeNode(node);
            appendRight(node);
            return;
        }

        DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
        map.put(key, node);
        appendRight(node);
        size++;

        if (size > capacity) {
            DoublyLinkedListNode lru = left.next;
            removeNode(lru);
            map.remove(lru.key);
            size--;
        }
    }
}