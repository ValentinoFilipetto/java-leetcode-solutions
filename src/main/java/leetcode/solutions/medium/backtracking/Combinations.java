package leetcode.solutions.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Pattern: Backtracking (DFS)
 * Time complexity:
 * Space complexity:
 */


public class Combinations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList<>());
        return res;    
    }   

    private void backtrack(int i, int n, int k, List<Integer> combination) {
        if (i == n + 1) {
            if (combination.size() == k) {
                res.add(new ArrayList<>(combination));   
            }
            return;
        }

        combination.add(i);
        backtrack(i + 1, n, k, combination);
        combination.remove(combination.size() - 1);
        backtrack(i + 1, n, k, combination);
    }
}
