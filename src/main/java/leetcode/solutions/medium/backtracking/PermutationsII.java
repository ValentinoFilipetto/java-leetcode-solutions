package leetcode.solutions.medium.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Pattern: Backtracking (DFS)
 * Time complexity: O(n * n!) in the worst case, since each unique permutation is generated and copied.
 * Space complexity: O(n) auxiliary space for recursion and the current permutation.
 *
 * Intuition: In Permutations I, we track which indices have been used because every number is distinct.
 * Here, equal numbers are interchangeable, so choosing different copies would create duplicate permutations.
 * Instead, we store how many copies of each number remain and choose only from those distinct numbers (i.e. entries).
 * For example, with [1, 1, 2], choosing 1 reduces its count, and backtracking restores the count so it
 * can be used in another position without generating the same choice twice at the current position.
 */

class PermutationsII {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            counter.putIfAbsent(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        this.backtrack(new ArrayList<>(), nums.length, counter);
        return res;
    }

    private void backtrack(
        List<Integer> combination,
        Integer n,
        HashMap<Integer, Integer> counter
    ) {
        if (combination.size() == n) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            
            if (count == 0) continue;

            combination.add(num);
            counter.put(num, count - 1);
            backtrack(combination, n, counter);
            combination.remove(combination.size() - 1);
            counter.put(num, count);
        }
    }
}