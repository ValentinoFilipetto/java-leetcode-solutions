package leetcode.solutions.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * Pattern: Stack
 * Time complexity: O(n log n) because of sorting
 * Space complexity: O(n)
 */

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        // Sort by position descending (closest to target first).
        // A car can only catch up on another car that is further ahead, not behind it.
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for (int[] pair : pairs) {
            double timeToArrive = (double)(target - pair[0]) / pair[1];

            // Only push if this car forms a new fleet (or the stack is empty of course)
            // i.e., it cannot catch up to the fleet ahead
            if (stack.isEmpty() || timeToArrive > stack.peek()) {
                stack.push(timeToArrive);
            }
        }
        return stack.size();
    }
}
