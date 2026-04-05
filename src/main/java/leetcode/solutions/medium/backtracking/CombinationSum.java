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
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, target, 0, new ArrayList<>(), res);
        return res;
    }

    /**
     * Note: we pass sum instead of a combination list, as otherwise we would need to
     * calculate the sum of the combination every time and this is not efficient.
     *
     */
    private void dfs(int[] nums, int i, int target, int sum,
                     List<Integer> combination, List<List<Integer>> res) {

        if (sum == target) {
            res.add(new ArrayList<>(combination));
            return;
        }

        if (i == nums.length || sum > target) return;

        // Option 1: skip nums[i].
        dfs(nums, i + 1, target, sum, combination, res);

        // Option 2: take nums[i].
        // Option 3: "take nums[i] only once" is obtained by means of the other two: take first time and then skip.
        combination.add(nums[i]);
        dfs(nums, i, target, sum + nums[i], combination, res);
        combination.removeLast(); // backtrack.
    }
}
