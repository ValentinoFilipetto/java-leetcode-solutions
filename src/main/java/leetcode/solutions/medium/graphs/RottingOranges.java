package leetcode.solutions.medium.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Pattern: Graphs (Multisource BFS)
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 * Intuition: Start BFS from every initially rotten orange at once. Each BFS layer represents one minute,
 * because all oranges that are rotten at the start of that minute spread rot simultaneously to their fresh neighbors.
 * Marking a fresh orange as rotten when it is enqueued also acts as the visited check.
 */

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{ r, c });
                }
                if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {{1, 0},{0, 1},{-1, 0},{0, -1}};
        int minutes = 0;
	    // Important: make sure that we also stop if fresh == 0
        while (fresh > 0 && !queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] cell = queue.poll();
                int currentRow = cell[0];
                int currentCol = cell[1];

                for (int[] dir : directions) {
		            // Calculate next cell coordinates.
                    int newRow = currentRow + dir[0];
                    int newCol = currentCol + dir[1];

                    // If next cell is out of bound, or empty, or already rotten, skip it.
                    if (newRow < 0 || newCol < 0 || newRow == rows || newCol == cols || grid[newRow][newCol] == 0 || grid[newRow][newCol] == 2) {
                        continue;
                    }

                    // Next cell is fresh, so make it rotten and decrease the amount of fresh cells.
                    grid[newRow][newCol] = 2;
                    fresh--;
                    queue.add(new int[]{ newRow, newCol });
                }
            }
            minutes++;
        }
	    // If there are still fresh cells but the queue stopped it means that some fresh cells are unreachable, so return -1;
        return fresh > 0 ? -1 : minutes;
    }
}
