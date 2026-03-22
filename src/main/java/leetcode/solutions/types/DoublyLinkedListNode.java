package leetcode.solutions.types;

public class DoublyLinkedListNode {
    public DoublyLinkedListNode next, prev;
    public int key, value;

    public DoublyLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}