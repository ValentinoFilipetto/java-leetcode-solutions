package leetcode.solutions.medium.twopointers;

/**
 * Pattern: Two Pointers
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int maxSize = 0;

        int l = 0, r = heights.length - 1;
        while (l < r) {
            int size = Math.min(heights[l], heights[r]) * (r - l);
            maxSize = Math.max(maxSize, size);

            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxSize;
    }
}
