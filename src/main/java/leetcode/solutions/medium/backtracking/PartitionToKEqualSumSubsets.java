package leetcode.solutions.medium.backtracking;

import java.util.Arrays;

/**
 * Pattern: Backtracking (DFS)
 * Time complexity: O(k^n) where n is the length of nums
 * Space complexity: O(n) for the recursion stack.
 * Intuition: see MatchsticksToSquare solution.
 */

public class PartitionToKEqualSumSubsets {
        public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        
        Arrays.sort(nums);
        reverse(nums);
        int subsetSum = sum / k;
        int[] subsets = new int[k];
        return backtrack(nums, subsets, k, subsetSum, 0);
    }

    private boolean backtrack(int[] nums, int[] subsets, int k, int subsetSum, int i) {
        if (i == nums.length) {
            for (int j = 0; j < k; j++) {
                if (subsets[j] != subsetSum) return false;
            }
            return true;
        }

        for (int j = 0; j < k; j++) {
            if (subsets[j] + nums[i] <= subsetSum) {
                subsets[j] += nums[i];
                if (backtrack(nums, subsets, k, subsetSum, i + 1)) return true;
                subsets[j] -= nums[i];
            }
        }
        return false;
    }

    private void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
