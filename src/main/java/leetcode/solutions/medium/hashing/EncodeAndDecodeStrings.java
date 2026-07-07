package leetcode.solutions.medium.hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern: Hashing + Two Pointers
 * Time complexity: O(n) for both encode and decode.
 * Space complexity: O(n) for both encode and decode.
 * */

public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int r = 0;
        int l;

        while (r < str.length()) {
            StringBuilder lengthAsString = new StringBuilder();

            // Find length of next string
            while (r < str.length() && (Character.isDigit(str.charAt(r)))) {
                lengthAsString.append(str.charAt(r));
                r++;
            }

            // Use length to add next string to result
            int length = Integer.parseInt(lengthAsString.toString());
            l = r + 1;
            r = l + length;
            res.add(str.substring(l, r));
        }
        return res;
    }
}
