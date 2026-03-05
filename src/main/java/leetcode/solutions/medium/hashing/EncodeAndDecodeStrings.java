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
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}
