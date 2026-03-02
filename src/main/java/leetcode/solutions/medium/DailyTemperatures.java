package leetcode.solutions.medium;

import java.util.Stack;

/**
 * Pattern: Stack
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // pair: [temp, index]

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[] { temp, i });
        }
        return res;
    }
}
