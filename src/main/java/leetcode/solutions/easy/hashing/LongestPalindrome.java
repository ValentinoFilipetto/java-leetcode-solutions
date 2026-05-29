package leetcode.solutions.easy.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Pattern: Hashing
 * Time complexity: O(n) where n is the length of s.
 * Space complexity: O(n)

 * Intuition: we first collect frequencies of characters.
 * If we get an even frequency we can just add it to maxLength as is,
 * if it is odd, we can add frequency - 1 (even). We also have to keep track
 * of the existence of at least one odd frequency (hasOddValues) as this will allow
 * us to add + 1 at the end (center letter of the constructed palindrome).
 */

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        int maxLength = 0;
        boolean hasOddValues = false;
        for (Integer frequency : frequencyMap.values()) {
            if (frequency % 2 == 0) maxLength += frequency;
            else {
                maxLength += frequency - 1;
                hasOddValues = true;
            }
        }
        return hasOddValues ? maxLength + 1 : maxLength;
    }
}
