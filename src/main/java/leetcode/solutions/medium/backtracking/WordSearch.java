package leetcode.solutions.medium.backtracking;

/**
 * Pattern: Backtracking (DFS)
 * Time complexity: O(m * 4^n), where m is the number of cells and n is the length of word.
 * Space complexity: O(n), for the recursion stack.
 */

public class WordSearch {
    private int ROWS, COLS;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                // We first check if the first character matches. This saves some time on large boards.
                if (board[r][c] == word.charAt(0) && backtrack(board, r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int r, int c, String word, int i) {
        if (i == word.length()) return true;

        if (r < 0 || c < 0 || r == ROWS || c == COLS ||
                board[r][c] == '#' || board[r][c] != word.charAt(i)) {
            return false;
        }

        char temp = board[r][c];
        // Remember: always modify grid in place when possible, instead of
        // using a set to keep track of visited cells, as it is more memory-efficient.
        board[r][c] = '#';

        boolean res =
                backtrack(board, r + 1, c, word, i + 1) ||
                        backtrack(board, r - 1, c, word, i + 1) ||
                        backtrack(board, r, c + 1, word, i + 1) ||
                        backtrack(board, r, c - 1, word, i + 1);

        board[r][c] = temp; // restore original char.
        return res;
    }
}
