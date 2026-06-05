package leetcode.solutions.easy.twopointers;

/**
 * Pattern: Two Pointers
 * Time complexity: O(n)
 * Space complexity: O(1), as the array is modified in place.
 * Intuition: we "move" occurrences of val to the end of the array in this way:
 * if we read a value that is not val, we write it, else we keep write where it is, and we advance with read only.
 * Advancing write *only* when a swap happens also allows us to keep it fixed on an occurrence of val when we find it.
 */

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int write = 0;

        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != val) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }
}
