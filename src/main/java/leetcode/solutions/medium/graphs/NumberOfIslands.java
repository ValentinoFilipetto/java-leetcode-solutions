package leetcode.solutions.medium.graphs;

/**
 * Pattern: Graphs (DFS)
 * Time complexity: O(m * n)
 * Space complexity: O(m * n), for the recursion stack.
 */

public class NumberOfIslands {
    private int ROWS;
    private int COLS;

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int numberOfIslands = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    numberOfIslands++;
                    dfs(grid, r, c);
                }
            }
        }
        return numberOfIslands;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r == ROWS || c == COLS || grid[r][c] == '0') {
            return;
        }

        // Mark cell as visited.
        grid[r][c] = '0';

        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
    }
}
