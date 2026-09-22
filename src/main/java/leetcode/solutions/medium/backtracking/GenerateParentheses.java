package leetcode.solutions.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern: Backtracking (DFS)
 * Time complexity: O(4^n / sqrt(n))
 * Explanation: we generate all sequences of length 2n and their number is the n-th Catalan number.
 * O(4^n / sqrt(n)) is the result of multiplying the Catalan number by n, which we need to do because, in the base case, 
 * we add our combination to the final list, which takes O(n).
 * Note: our string management technically takes more than O(n) (O(n^2)) as we are creating a brand-new string every time
 * we recursively call dfs().
 * Space complexity: O(n), for the recursion stack.
 */	
	
class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(2 * n), res);
        return res;
    }

    private void backtrack(int n, int open, int close, StringBuilder sb, List<String> res) {
        if (open == close && close == n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            backtrack(n, open + 1, close, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            backtrack(n, open, close + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
