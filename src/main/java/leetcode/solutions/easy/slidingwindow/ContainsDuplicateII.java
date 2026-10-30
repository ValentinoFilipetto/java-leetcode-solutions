package leetcode.solutions.easy.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Pattern: Sliding Window
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Intuition: the condition Math.abs(l - r) <= k, means that we can check windows of size at most k.
 */

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            // If current window grows larger than k, shrink it.
            if (r - l > k) {
                seen.remove(nums[l]);
                l++;
            }
            
            // If a duplicate is found, return true.
            if (!seen.isEmpty() && seen.contains(nums[r])) return true;

            seen.add(nums[r]);
            r++;
        }
        return false;
    }
}
