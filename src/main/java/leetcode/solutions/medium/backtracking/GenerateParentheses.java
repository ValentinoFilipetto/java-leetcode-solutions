package leetcode.solutions.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern: Backtracking (DFS)

 * Time complexity: O(4^n / sqrt(n))
 * Explanation: we generate all sequences of length 2n and their number is the n-th Catalan number.
 * O(4^n / sqrt(n)) is the result of multiplying the Catalan number by n, which we need to do because,
 * in the base case, we add our combination to the final list, which takes O(n).
 * Note: our string management technically takes more than O(n) (O(n^2)) as we are creating a brand-new string every time
 * we recursively call dfs().

 * Space complexity: O(n), for the recursion stack.

 * Note: since we are using String data type, which is immutable, we do not need to do manual state management.
 * Every time we write, e.g., string + '(', a new string gets created in memory.
 * Possible interview follow-up: how would you make this more memory-efficient? By using StringBuilder, which is mutable.
 * This of course will imply that we need to do more state management, in particular by popping: sb.deleteCharAt(sb.length() - 1);
 */	
	
public class GenerateParentheses {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, "", 0, 0);
        return res;
    }

    private void dfs(int n, String string, int numberOpen, int numberClosed) {
        // When string is balanced, and we reached n, string is a valid combination.
        // This is true only if we respected below rules though, because, e.g.
        // ")))(((" would pass this base case for n = 3.
        if (n == numberOpen && numberOpen == numberClosed) {
            res.add(string);
            return;
        }

        // By default, insert '(' if possible.
        if (numberOpen < n) {
            dfs(n, string + '(', numberOpen + 1, numberClosed);
        }
	
        // Insert ')' as long as our combination does not become unbalanced.
        if (numberClosed + 1 <= numberOpen) {
            dfs(n, string + ')', numberOpen, numberClosed + 1);
        }
    }
}
