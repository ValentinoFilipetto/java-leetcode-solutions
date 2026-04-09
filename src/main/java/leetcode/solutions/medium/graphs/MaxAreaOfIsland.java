package leetcode.solutions.medium.graphs;

/**
 * Pattern: Graphs (DFS)
 * Time complexity: O(m * n)
 * Space complexity: O(m * n), for the recursion stack.
 */

public class MaxAreaOfIsland {
    private int ROWS;
    private int COLS;

    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int maxArea = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c, 0));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, int area) {
        if (r < 0 || c < 0 || r == ROWS || c == COLS || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        return 1 + dfs(grid, r + 1, c, area + 1) +
                dfs(grid, r, c + 1, area + 1) +
                dfs(grid, r - 1, c, area + 1) +
                dfs(grid, r, c - 1, area + 1);
    }
}
