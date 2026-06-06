package leetcode.solutions.easy.twopointers;

/**
 * Pattern: Two Pointers
 * Time complexity: O(m + n)
 * Space complexity: O(m + n)
 */

public class MergeStringAlternately {
    public String mergeAlternately(String word1, String word2) {
        // Use StringBuilder for better memory usage.
        StringBuilder res = new StringBuilder();
        int i = 0, j = 0;

        while (i < word1.length() && j < word2.length()) {
            res.append(word1.charAt(i++));
            res.append(word2.charAt(j++));
        }

        // Here we do not risk indexOutOfBounds because substring() does not
        // throw if index == word.length, unlike e.g. charAt().
        res.append(word1.substring(i));
        res.append(word2.substring(j));
        return res.toString();
    }
}
