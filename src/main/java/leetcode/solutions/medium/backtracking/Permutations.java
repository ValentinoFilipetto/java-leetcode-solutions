package leetcode.solutions.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern: Backtracking (DFS)
 * Time complexity: O(n * n!), as we generate every possible permutation (n!) and we copy it (n).
 * Space complexity: O(n), for the recursion depth and the `pick` list we keep throughout the algorithm.
 */

public class Permutations {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    /** `pick` array tells us which elements we already picked in the current combination. */
    private void dfs(int[] nums, List<Integer> permutation, boolean[] pick) {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                pick[i] = true;
                permutation.add(nums[i]);
                dfs(nums, permutation, pick);
                // backtrack.
                permutation.removeLast();
                pick[i] = false;
            }
        }
    }
}
