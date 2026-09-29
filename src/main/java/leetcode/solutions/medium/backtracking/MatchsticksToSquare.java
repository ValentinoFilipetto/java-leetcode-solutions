package leetcode.solutions.medium.backtracking;

import java.util.Arrays;

/**
 * Pattern: Backtracking (DFS)
 * Time complexity: O(4^n) where n is the length of matchsticks
 * Space complexity: O(n) for the recursion stack.
 * Intuition: we try every possible combination of matchsticks for all sides.
 * If a correct combination is found, we return true and propagate this result up through the call stack.
 * We also have two optimizations:
 * 1) If a combination overflows for one side, we skip it right away
 * 2) We sort matchsticks in reverse order so that we process the longest first, in order to shortcircuit earlier.
 */

public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        int length = sum / 4;
        if (sum % 4 != 0) return false;

        int[] sides = new int[4];
        return backtrack(matchsticks, sides, length, 0);
    }

    private boolean backtrack(int[] matchsticks, int[] sides, int length, int i) {
        if (i == matchsticks.length) {
            return sides[0] == sides[1] && 
                   sides[1] == sides[2] && 
                   sides[2] == sides[3];
        }

        for (int j = 0; j < sides.length; j++) {
            // If a combination overflows for one side, we skip it right away.
            if (sides[j] + matchsticks[i] <= length) {
                sides[j] += matchsticks[i];
                // If a correct combination is found, propagate true up through the call stack.
                if (backtrack(matchsticks, sides, length, i + 1)) return true;
                sides[j] -= matchsticks[i];
            }
        }
        return false;
    }

    private void reverse(int[] matchsticks) {
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
    }
}