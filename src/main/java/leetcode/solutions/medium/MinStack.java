package leetcode.solutions.medium;

import java.util.Stack;

/**
 * Pattern: Stack
 * Time complexity: O(1) for all operations
 * Space complexity: O(n)
 */

public class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> normalStack;

    public MinStack() {
        minStack = new Stack<>();
        normalStack = new Stack<>();
    }

    public void push(int val) {
        normalStack.push(val);

        // Do not forget to use <=
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int poppedElement = normalStack.pop();
        if (poppedElement == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return normalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

