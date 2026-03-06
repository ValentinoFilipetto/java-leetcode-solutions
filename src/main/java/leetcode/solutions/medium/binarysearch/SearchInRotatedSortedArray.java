package leetcode.solutions.medium.binarysearch;

/**
 * Pattern: Binary Search
 * Time complexity: O(log n), the worst case is if the array is not actually rotated.
 * Space complexity: O(1)
 */

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // Same idea as in "Find minimum in rotated sorted array".
        while (left < right) {
            int m = (left + right) / 2;

            // We are on the left side.
            if (nums[m] > nums[right]) {
                left = m + 1;
            } else {
                right = m;
            }
        }

        int pivot = left;
        left = 0;
        right = nums.length - 1;

        // Given the pivot, identify on which side the target *may* be.
        // Then, since each side is sorted, we can binary search it.
        if (target >= nums[pivot] && target <= nums[right]) {
            left = pivot;
        } else {
            right = pivot - 1;
        }

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
