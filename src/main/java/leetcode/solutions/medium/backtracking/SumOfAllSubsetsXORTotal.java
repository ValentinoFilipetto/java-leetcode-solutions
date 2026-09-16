package leetcode.solutions.medium.backtracking;

/**
 * Pattern: DFS
 * Time complexity: O(2^n), as there are two choices per element.
 * Space complexity: O(n), for max recursion depth.
 */

public class SumOfAllSubsetsXORTotal {
    // Keep the running total in a field so each recursive call can update it.
    // Java passes primitive values by value, so changes to an int parameter
    // would not be visible to the caller.
    int res = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int i, int xor) {
        if (i == nums.length) {
            res += xor;
            return;
        }

        dfs(nums, i + 1, xor ^ nums[i]);
        dfs(nums, i + 1, xor);
    }
}
