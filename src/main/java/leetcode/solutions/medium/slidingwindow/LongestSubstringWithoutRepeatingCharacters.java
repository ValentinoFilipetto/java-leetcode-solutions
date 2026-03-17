package leetcode.solutions.medium.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Pattern: Sliding Window
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int l = 0;
        int maxSubstringLength = 0;

        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            maxSubstringLength = Math.max(maxSubstringLength, r - l + 1);
        }
        return maxSubstringLength;
    }
}
