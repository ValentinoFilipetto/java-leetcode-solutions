package leetcode.solutions.easy.twopointers;

/**
 * Pattern: Two Pointers
 * Time complexity: O(n)
 * Space complexity: O(1)
 * */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !isAlphaNum(s.charAt(left))) left++;
            while (right > left && !isAlphaNum(s.charAt(right))) right--;

            // The problem statement expects us to compare only lowercase characters.
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++; right--;
        }
        return true;
    }

    private boolean isAlphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }

    // Above method could also be
    // private boolean isAlphaNum(char c) {
    //  return isLetter(c) || isDigit(c);
    // }
}
