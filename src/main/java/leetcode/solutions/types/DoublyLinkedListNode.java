package leetcode.solutions.types;

class DoublyLinkedListNode {
    public DoublyLinkedListNode next, prev;
    public int key, value;

    public DoublyLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}