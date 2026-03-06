package leetcode.solutions.medium.binarysearch;

/**
 * Pattern: Binary Search
 * Time complexity: O(log n)
 * Space complexity: O(1)
 */

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        // If array is already sorted, return first value.
        if (nums[0] < nums[nums.length - 1]) return nums[0];

        int left = 0, right = nums.length - 1;
        // If left == right, we found the minimum value.
        while (left < right) {
            int m = (left + right) / 2;

            // we are on the right side.
            if (nums[m] < nums[right]) {
                right = m;
            } else if (nums[m] > nums[right]) { // we are on the left side.
                left = m + 1;
            }
        }
        // right would also do.
        return nums[left];
    }
}
