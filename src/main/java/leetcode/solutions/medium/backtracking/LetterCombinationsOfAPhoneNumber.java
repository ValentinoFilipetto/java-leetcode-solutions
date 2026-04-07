package leetcode.solutions.medium.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Pattern: Backtracking (DFS)
 * Time complexity: O(n * 4ⁿ), where n comes from combination.toString() and 4ⁿ
 * from the fact that we have 4 letters per digit in the worst case.
 * Space complexity: O(n)
 */

public class LetterCombinationsOfAPhoneNumber {
    // Using char[] instead of List<Character> avoids boxing, reduces memory use,
    // and iterates faster. Lists store Character objects (heap + indirection),
    // while char[] is primitive, compact, and ideal for high‑performance backtracking.
    private static final Map<Character, char[]> KEYPAD = Map.of(
            '2', new char[]{'a','b','c'},
            '3', new char[]{'d','e','f'},
            '4', new char[]{'g','h','i'},
            '5', new char[]{'j','k','l'},
            '6', new char[]{'m','n','o'},
            '7', new char[]{'p','q','r','s'},
            '8', new char[]{'t','u','v'},
            '9', new char[]{'w','x','y','z'}
    );

    private final List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        // StringBuilder is the mutable version of String.
        // We use StringBuilder instead of String for the huge performance boost it gives in backtracking.
        backtracking(0, digits, new StringBuilder());
        return res;
    }

    private void backtracking(int i, String digits, StringBuilder combination) {
        if (i == digits.length()) {
            res.add(combination.toString());
            return;
        }

        char[] characters = KEYPAD.get(digits.charAt(i));
        for (char character : characters) {
            combination.append(character);
            backtracking(i + 1, digits, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
