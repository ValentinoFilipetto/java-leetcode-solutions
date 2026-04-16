package leetcode.solutions.medium.tries;

import leetcode.solutions.types.TrieNode;

/**
 * Pattern: Trie
 * Time complexity: O(n), for all function calls, where n is the length of word.
 * Space complexity: O(n), because we create one TrieNode per character in word.
 */

public class ImplementTrie {
    private final TrieNode root;

    public ImplementTrie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;

        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;

        for (char c : word.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else return false;
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;

        for (char c : prefix.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else return false;
        }
        return true;
    }
}
