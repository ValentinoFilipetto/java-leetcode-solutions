package leetcode.solutions.medium.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Pattern: Graphs (Multisource BFS)
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int ROWS = mat.length;
        int COLS = mat[0].length;
        Deque<int[]> queue = new ArrayDeque<>();

        // Mark unvisited cells as -1
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (mat[r][c] == 0) {
                    queue.add(new int[]{r, c});
                } else mat[r][c] = -1;
            }
        }

        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for (int[] d : directions) {
                int nr = cell[0] + d[0];
                int nc = cell[1] + d[1];

                if (nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS ||
                        mat[nr][nc] != -1) continue;

                mat[nr][nc] = mat[cell[0]][cell[1]] + 1;
                queue.add(new int[]{ nr, nc });
            }
        }
        return mat;
    }
}
