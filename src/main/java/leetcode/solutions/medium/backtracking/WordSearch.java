package leetcode.solutions.medium.backtracking;

/**
 * Pattern: Backtracking (DFS)
 * Time complexity: O(m * 4^n), where m is the number of cells and n is the length of word.
 * Space complexity: O(n), for the recursion stack.
 */

public class WordSearch {
    char[][] board;
    int rows;
    int cols;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0) && backtrack(r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int r, int c, String word, int i) {
        if (i == word.length()) return true;
        if (r < 0 || c < 0 || r >= rows || c >= cols || 
            board[r][c] == '#' || board[r][c] != word.charAt(i)) {
            return false;
        }

        board[r][c] = '#';
        boolean res = backtrack(r + 1, c, word, i + 1) ||
                      backtrack(r - 1, c, word, i + 1) ||
                      backtrack(r, c + 1, word, i + 1) ||
                      backtrack(r, c - 1, word, i + 1);
        board[r][c] = word.charAt(i);
        return res;
    }
}
