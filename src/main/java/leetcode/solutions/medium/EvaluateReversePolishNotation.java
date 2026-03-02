package leetcode.solutions.medium;

import java.util.Stack;

/**
 * Pattern: Stack
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String t : tokens) {
            switch (t) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 - num1);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 / num1); // Integer division required here by statement.
                }
                default -> stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}