package leetcode.solutions.medium.slidingwindow;

/**
 * Pattern: Sliding Window
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int currMin = Integer.MAX_VALUE;
        int windowSum = 0;
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            windowSum += nums[r];
            while (windowSum >= target) {
                currMin = Math.min(currMin, r - l + 1);
                windowSum -= nums[l];
                l++;
            }
            r++;
        }
        return currMin == Integer.MAX_VALUE ? 0 : currMin;
    }
}
