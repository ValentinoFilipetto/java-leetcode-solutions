package leetcode.solutions.easy.binarysearch;

/**
 * Pattern: Binary Search
 * Time complexity: O(log n)
 * Space complexity: O(1)
 * */

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int m = (left + right) / 2;

            if (target > nums[m]) {
                left = m + 1;
            } else if (target < nums[m]) {
                right = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
