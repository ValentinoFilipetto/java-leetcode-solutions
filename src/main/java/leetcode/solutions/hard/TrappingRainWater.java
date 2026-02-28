package leetcode.solutions.hard;

/**
 * Pattern: Two Pointers
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        int maxLeft = 0, maxRight = 0;
        int l = 0, res = 0, r = height.length - 1;

        while (l < r) {
            if (maxLeft > height[l] && maxRight > height[l]) {
                res += Math.min(maxLeft, maxRight) - height[l];
            } else if (maxLeft > height[r] && maxRight > height[r]) {
                res += Math.min(maxLeft, maxRight) - height[r];
            }

            maxLeft = Math.max(maxLeft, height[l]);
            maxRight = Math.max(maxRight, height[r]);

            if (height[l] < height[r]) l++;
            else {
                r--;
            }
        }
        return res;
    }
}
