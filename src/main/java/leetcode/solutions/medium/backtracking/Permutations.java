package leetcode.solutions.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern: Backtracking (DFS)
 * Time complexity: O(n * n!), as we generate every possible permutation (n! possible permutations) and we copy it in O(n).
 * Space complexity: O(n), for the recursion depth and the `pick` list we keep throughout the algorithm.
 * 
 * Intuition: Build each permutation one number at a time. At every step, try each number that has not
 * been used yet, explore that choice, and then remove it so another number can be tried in its place.
 * Example: for input [1, 2, 3], we first obtain permutation [1, 2, 3], then we remove 3 and make it up for grabs.
 * Once we backtracked to level 2, our permutation is [1, 2], we remove 2, and we still have one iteration of the loop to be done.
 * That iteration appends 3, giving us [1, 3]. We then go down one level and add 2 (the last element available), thus producing [1, 3, 2].
 */

public class Permutations {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, boolean[] pick, List<Integer> perm) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                perm.add(nums[i]);
                pick[i] = true;
                backtrack(nums, pick, perm);
                perm.remove(perm.size() - 1);
                pick[i] = false;
            }
        }
    }
}
