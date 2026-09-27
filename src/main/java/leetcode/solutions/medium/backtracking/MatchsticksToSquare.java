package leetcode.solutions.medium.backtracking;

import java.util.Arrays;

public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;

        int[] sides = new int[4];
        return dfs(matchsticks, sides, 0);
    }

    private boolean dfs(int[] matchsticks, int[] sides, int i) {
        if (i == matchsticks.length) {
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }

        for (int j = 0; j < 4; j++) {
            sides[j] += matchsticks[i];
            if (dfs(matchsticks, sides, i + 1)) return true;
            sides[j] -= matchsticks[i];
        }

        return false;
    }
}