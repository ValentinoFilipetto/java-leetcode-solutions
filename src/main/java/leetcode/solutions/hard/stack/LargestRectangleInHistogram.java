package leetcode.solutions.hard.stack;

import java.util.Stack;

/**
 * Pattern: Stack
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        // Left and right boundaries: until which index can we "extend" a bar to the left and to the right?
        int[] left = new int[n];
        int[] right = new int[n];

        // Find the left boundaries
        for (int i = 0; i < n; i++) {
            left[i] = -1;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        // Find the right boundaries
        for (int i = n - 1; i >= 0; i--) {
            right[i] = n;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int largestArea = 0;
        for (int i = 0; i < n; i++) {
            // left[i] and right[i] are exclusive boundaries (the first shorter bar on each side),
            // so the width is the count of indices strictly between them: right[i] - left[i] - 1
            largestArea = Math.max(largestArea, heights[i] * (right[i] - left[i] - 1));
        }
        return largestArea;
    }
}
