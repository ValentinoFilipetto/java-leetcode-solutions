package leetcode.solutions.easy.twopointers;

/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Intuition: if we find a mismatch, try skipping the left value and the right value.
 * If any of the two return true, then return true, else return false.
 */

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

