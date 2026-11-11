package leetcode.solutions.medium.slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Pattern: Sliding Window
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Note: Strings in sets are automatically compared by value, not by reference.
 */

public class FindRepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
    int l = 0;
    Set<String> res = new HashSet<>();
    Set<String> seen = new HashSet<>();

    for (int r = 0; r < s.length(); r++) {
        String window = s.substring(l, r + 1);

        if (r + 1 >= 10) {
            if (seen.contains(window)) res.add(window);
            if (!res.contains(window)) seen.add(window);
            l++;
        }
    }
    return new ArrayList<>(res);
    }    
}
