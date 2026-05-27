package leetcode.solutions.easy.twopointers;

/**
 * Pattern: Two Pointers
 * Time complexity: O(n)
 * Space complexity: O(1)
 * */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !isAlphaNum(s.charAt(l))) l++;
            while (r > l && !isAlphaNum(s.charAt(r))) r--;

            // The problem statement expects us to compare only lowercase characters.
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            // Do not forget to move pointers here too.
            l++; r--;
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
