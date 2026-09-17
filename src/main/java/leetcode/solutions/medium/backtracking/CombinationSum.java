package leetcode.solutions.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern: Backtracking (DFS)
 * Time complexity: O(2^(t/m)), where 2 comes from the two choices we have at each step (pick/take).
 * Space complexity: O(t/m)
 * Where t is the given target and m is the minimum value in nums.
 */

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, 0, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, int target, int sum,
                     List<Integer> combination) {
        if (sum == target) {
            res.add(new ArrayList<>(combination));
            return;
        }

        if (i == nums.length || sum > target) return;

        combination.add(nums[i]);
        dfs(nums, i, target, sum + nums[i], combination);
        combination.remove(combination.size() - 1);
        dfs(nums, i + 1,target, sum, combination);
    }
}
