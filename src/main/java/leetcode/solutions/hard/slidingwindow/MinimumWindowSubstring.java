package leetcode.solutions.hard.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Pattern: Sliding Window
 * Time complexity: O(n + m)
 * Space complexity: O(n + m), but practically, since alphabet is bounded (ASCII or Unicode subset), O(1).
 */

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.isEmpty()) return "";

        // Count frequencies of characters in t.
        Map<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            countT.put(t.charAt(i), 1 + countT.getOrDefault(t.charAt(i), 0));
        }

        int have = 0, minSoFar = Integer.MAX_VALUE, need = countT.size();
        Map<Character, Integer> window = new HashMap<>();
        int[] res = { -1, -1 };
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char characterS = s.charAt(r);
            window.put(characterS, 1 + window.getOrDefault(characterS, 0));

            // `have` means that our window contains a character occurring in t and with the same frequency.
            if (countT.containsKey(characterS) && countT.get(characterS).equals(window.get(characterS))) {
                have++;
            }

            // While have == need, we can remove on the left and potentially find a smaller window.
            // If we start lacking something in the window, we leave the while loop and increase r, continuing the search.
            while (have == need) {
                if ((r - l + 1) < minSoFar) {
                    minSoFar = (r - l + 1);
                    res[0] = l;
                    res[1] = r;
                }

                // Do all the updates that follow l++.
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        // We need res[1] + 1 as .substring() is exclusive on the right.
        return minSoFar == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
