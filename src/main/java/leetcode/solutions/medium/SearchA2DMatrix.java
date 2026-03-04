package leetcode.solutions.medium;

/**
 * Pattern: Binary Search
 * Time complexity: O(log(m * n))
 * Space complexity: O(1)
 * */

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int indexToSearch = -1;

        // Find subarray where target *may* be.
        for (int i = 0; i < matrix.length; i++) {
            int[] subarray = matrix[i];
            if (subarray[0] <= target && target <= subarray[subarray.length - 1]) {
                indexToSearch = i;
            }
        }

        if (indexToSearch == -1) return false;

        // If that subarray exists, binary search it.
        int left = 0, right = matrix[indexToSearch].length - 1;
        while (left <= right) {
            int m = (left + right) / 2;

            if (target > matrix[indexToSearch][m]) {
                left = m + 1;
            } else if (target < matrix[indexToSearch][m]) {
                right = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
