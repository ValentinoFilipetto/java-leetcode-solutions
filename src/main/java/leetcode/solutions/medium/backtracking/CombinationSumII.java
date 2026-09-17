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
 * When we backtrack to the same depth of the first 2, we do not want to go directly in the `skip` branch, because
 * this will create duplicates, as there is a combination where we take the second 2 and 6 again.
 * We want to skip duplicates first and then go to the skip branch.
 */

public class CombinationSumII {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int i, List<Integer> combination, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(combination));
            return;
        }
        if (i >= candidates.length || sum > target) return;

        combination.add(candidates[i]);
        dfs(candidates, target, i + 1, combination, sum + candidates[i]);
        combination.remove(combination.size() - 1);

        while (i <  candidates.length  - 1 && candidates[i] == candidates[i + 1]) i++;

        dfs(candidates, target, i + 1, combination, sum);
    }
}
