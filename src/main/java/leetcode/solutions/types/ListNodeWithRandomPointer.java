package leetcode.solutions.types;

public class ListNodeWithRandomPointer {
    public int val;
    public ListNodeWithRandomPointer next;
    public ListNodeWithRandomPointer random;

    public ListNodeWithRandomPointer(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
