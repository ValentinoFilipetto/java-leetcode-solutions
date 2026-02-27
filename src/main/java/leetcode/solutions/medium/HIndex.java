package leetcode.solutions.medium;

import java.util.Arrays;

/**
 * Pattern: Sorting
 * Time complexity: O(n log n)
 * Space complexity: O(log n) - due to sorting stack
 * */

public class HIndex {
    public int hIndex(int[] citations) {
        // 1. Sort the citations (e.g., [3, 0, 6, 1, 5] -> [0, 1, 3, 5, 6])
        Arrays.sort(citations);
        int n = citations.length;

        // 2. Iterate to find the point where citations >= remaining papers
        for (int i = 0; i < n; i++) {
            int hCandidate = n - i; // Number of papers with at least citations[i] citations
            if (citations[i] >= hCandidate) {
                return hCandidate;
            }
        }

        return 0;
    }
}
