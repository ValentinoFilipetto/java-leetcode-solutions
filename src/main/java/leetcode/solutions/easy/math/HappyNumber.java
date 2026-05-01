package leetcode.solutions.easy.math;

import java.util.HashSet;
import java.util.Set;

/*
 * Pattern: Math (Hashing)
 * Time Complexity: O(log n)
 * Each iteration computes the sum of the squares of n’s digits, which
 * takes O(log n) time. The process quickly converges to a small range,
 * so the number of iterations is constant-bounded.
 *
 * Space Complexity: O(log n)
 * A HashSet stores previously seen values to detect cycles. The number
 * of stored values is bounded by the digit-square sequence size.
 */


public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (!seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
            if (n == 1) return true;
        }
        return false;
    }

    private int sumOfSquares(int n) {
        int output = 0;

        while (n > 0) {
            int digit = n % 10;
            output += (int) Math.pow(digit, 2);
            n /= 10;
        }
        return output;
    }
}
