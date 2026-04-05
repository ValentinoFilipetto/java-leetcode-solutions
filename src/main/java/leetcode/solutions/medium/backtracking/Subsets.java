package leetcode.solutions.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern: Backtracking (DFS)
 * Time complexity: O(n * 2^n), as there are two choices per element and each copy costs O(n).
 * Space complexity: O(n), for max recursion depth. This does not consider output list.
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i == nums.length) {
            // new ArrayList<>(subset) creates a "shallow copy" of subset, which means that elements are not copied, but the list itself is.
            // The reason why we need a copy is that ArrayList is a reference type, and as such its reference
            // would still be accessible in other recursive calls (e.g. when we pop from it), but we do not want that.
            res.add(new ArrayList<>(subset));
            return;
        }

        dfs(nums, i + 1, subset, res);
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, res);
        subset.removeLast();
    }
}
