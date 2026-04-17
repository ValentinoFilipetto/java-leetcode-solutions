package leetcode.solutions.medium.tries;

import leetcode.solutions.types.TrieNode;

/**
 * Pattern: Tries (DFS)
 * Time complexity: O(n) for both methods, where n is the length of word.
 * The reason this is the case despite the wildcard is that there is a constraint in this problem:
 * - there will be at most two dots in word. This means that, in the worst case when the two dots are
 * one after the other, we will have 26² = 676 checks, so the result is O(676 * n) = O(n). If it was not
 * for this constraint, the time complexity would be O(26ⁿ), exponential.

 * Space complexity: O(n), because we create one TrieNode per character in word.
 */

public class DesignAddAndSearchWordDataStructure {
    TrieNode root;

    public DesignAddAndSearchWordDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = this.root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, this.root);
    }

    private boolean dfs(String word, int i, TrieNode curr) {
        if (i == word.length()) return curr.isEndOfWord;

        char currentChar = word.charAt(i);

        if (currentChar != '.') {
            TrieNode next = curr.children.get(currentChar);
            // Check if character was inserted before in the Trie.
            if (next == null) return false;
            return dfs(word, i + 1, next);
        }

        // currentChar == '.', the wildcard.
        for (TrieNode child : curr.children.values()) {
            // Important! At least one path needs to be good to return true.
            if (dfs(word, i + 1, child)) {
                return true;
            }
        }
        return false;
    }
}
