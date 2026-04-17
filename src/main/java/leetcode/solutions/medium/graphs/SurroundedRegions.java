package leetcode.solutions.medium.graphs;

/**
 * Pattern: Graphs (DFS)
 * Time complexity: O(m * n)
 * Space complexity: O(m * n), because of the recursive stack needed in the worst case.
 * Intuition: we identify the non-surrounded regions first, and everything else has to be surrounded.
 */

public class SurroundedRegions {
    int rows;
    int cols;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        // Check left and right borders.
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if (board[r][cols - 1] == 'O') {
                dfs(board, r, cols - 1);
            }
        }

        // Check top and bottom borders.
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if (board[rows - 1][c] == 'O') {
                dfs(board, rows - 1, c);
            }
        }

        // Explore the board one final time:
        // if we find '*', restore 'O',
        // otherwise, mark it with 'X', as the cell is surrounded.
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == '*') board[r][c] = 'O';
                else if (board[r][c] == 'O') board[r][c] = 'X';
            }
        }
    }

    // Explore paths with 'O' and mark them as visited with '*'.
    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r == rows || c == cols || board[r][c] == 'X' || board[r][c] == '*') {
            return;
        }

        board[r][c] = '*';
        dfs(board, r + 1, c);
        dfs(board, r, c + 1);
        dfs(board, r - 1, c);
        dfs(board, r, c - 1);
    }
}
