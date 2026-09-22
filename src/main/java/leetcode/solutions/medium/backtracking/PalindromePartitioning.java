package leetcode.solutions.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern: Backtracking (DFS)
 * Time complexity: O(n * 2^n)
 * Space complexity: O(n^2) for the recursion depth.
 */

public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int l, int r, List<String> partition) {
        if (r == s.length()) {
            if (l == r) res.add(new ArrayList<>(partition));
            return;
        }

        if (isPalindrome(s, l, r)) {
            partition.add(s.substring(l, r + 1));
            backtrack(s, r + 1, r + 1, partition);
            partition.remove(partition.size() - 1);
        }
        backtrack(s, l, r + 1, partition);
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
