package leetcode.solutions.easy.stack;

import java.util.Stack;

/**
 * Pattern: Stack
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (!stack.isEmpty() && c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (!stack.isEmpty() && c == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
