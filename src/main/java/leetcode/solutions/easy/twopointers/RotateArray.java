package leetcode.solutions.easy.twopointers;

/**
 * Pattern: Two Pointers
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Intuition:
 * A clever observation: rotating an array by k is equivalent to moving the last k elements to the front.
 * We can achieve this with three reversals. First, reverse the entire array. Now the last k elements are at the front, but in reverse order.
 * Reverse the first k elements to fix their order. Finally, reverse the remaining elements to restore their original order.
 */

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // as k could be larger than n.
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}
