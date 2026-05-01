package leetcode.solutions.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pattern: Backtracking (DFS)
 * Time complexity: O(n * 2^n), as there are up to 2^n subsets and for each of them we can take a copy in O(n).
 * Space complexity: O(n) for the recursion depth.

 * Example: candidates sorted → [1,2,2,4,5,6,9], target = 8.
 * The combination [2,6] should appear once even though there are two 2's.
 * We include the first 2 → explore → find [2,6].
 * After backtracking, we return to the same depth and skip the second 2,
 * otherwise we will get a duplicate. Note: why skipping duplicates before and not
 * after going in the 'skip' branch on line 46? Because if we go in the 'skip' branch
 * when we return at the same depth of the first 2, then there is a combination where we take
 * the second 2 and 6 again, which leads to a duplicate. We want to skip duplicates first and then
 * go to the skip branch.
 */

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, 0, target, 0, combination, res);
        return res;
    }

    private void dfs(int[] candidates, int i, int target, int sum,
                     List<Integer> combination, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(combination));
            return;
        }

        if (i >= candidates.length || sum > target) return;

        combination.add(candidates[i]);
        dfs(candidates, i + 1, target, sum + candidates[i], combination, res);
        combination.removeLast();

        // This is the same idea used in ThreeSum.
        while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) i++;

        dfs(candidates, i + 1, target, sum, combination, res);
    }
}
