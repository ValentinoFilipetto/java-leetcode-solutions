package leetcode.solutions.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pattern: Backtracking (DFS)
 * Time complexity: O(n * 2^n), as there are two choices per element and each copy costs O(n).
 * Space complexity: O(n), for max recursion depth.
 */

public class SubsetsII {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> subset) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(nums, i + 1, subset);
        subset.removeLast();

        // Same idea as Combination Sum II and Three Sum.
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;

        dfs(nums, i + 1, subset);
    }
}
