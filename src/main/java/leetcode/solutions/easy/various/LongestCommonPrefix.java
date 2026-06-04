package leetcode.solutions.easy.various;

/**
 * Pattern: Vertical Scanning (Iteration)
 * Time complexity: O(n * m), where n is the number of strings and m is the average length of these strings.
 * Space complexity: O(1), since we did not use extra space.
 * Intuition: compare character at index i for each string.
 * As soon as a mismatch is found, return prefix without last character, i.e. strs[0].substring(0, index)
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;

        while (true) {
            if (index >= strs[0].length()) return strs[0].substring(0, index);

            char curr = strs[0].charAt(index);

            for (String s : strs) {
                if (index >= s.length() || s.charAt(index) != curr) {
                    return strs[0].substring(0, index);
                }
            }
            index++;
        }
    }
}
