package leetcode.solutions.easy.graphs;

/**
 * Pattern: Graphs
 * Time complexity: O(n * m)
 * Space complexity: O(m * n)
 */

class Solution {
    int ROWS;
    int COLS;
    int color;
    int originalColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.ROWS = image.length;
        this.COLS = image[0].length;
        this.color = color;
        this.originalColor = image[sr][sc];
        flood(image, sr, sc);
        return image;
    }

    private void flood(int[][] image, int r, int c) {
        if (r < 0 || c < 0 || r == ROWS || c == COLS || image[r][c] != originalColor
                || image[r][c] == color) return;

        image[r][c] = color;

        flood(image, r + 1, c);
        flood(image, r, c + 1);
        flood(image, r - 1, c);
        flood(image, r, c - 1);
    }
}