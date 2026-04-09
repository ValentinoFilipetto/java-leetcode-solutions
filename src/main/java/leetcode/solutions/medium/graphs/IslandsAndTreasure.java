package leetcode.solutions.medium.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Pattern: Graphs (Multisource BFS)
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 * Intuition: We apply multisource BFS in the following way:
 * - start from treasure locations and explore adjacent land from there.
 * - for example, at treasure (r, c) we check adjacent cells and add the non-visited land cells to the queue,
     marking them as `1` as that is the shortest path.
   - we then continue with the next element in the queue: if it is a treasure, we do the same as before,
     otherwise we continue with a land cell.
   - there is no danger that we explore already visited cells as we only add untouched land cells to the queue
     (i.e. where value = Integer.MAX_VALUE).
 */

public class IslandsAndTreasure {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
	
	    // Add all treasure locations to the queue.
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) {
                    queue.add(new int[]{ r, c });
                }
            }
        }

        int[][] directions = new int[][]{new int[]{1, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currentRow = cell[0];
            int currentCol = cell[1];

            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];

                // Continue if next cell is outside of grid or is not land (Integer.MAX_VALUE).
                // This is what we do NOT want to add to the queue:
		        // - water
		        // - treasures
		        // - land whose value is less than Integer.MAX_VALUE (these were already visited before).
                if (newRow < 0 || newCol < 0 || newRow == ROWS || newCol == COLS || grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }

                // So we are dealing with land on the next cell.
                // Update that cell with the value of the current cell + 1. e.g. if current cell is a treasure, next land cell
                // will be 0 + 1 = 1, which is what we expect.
		        // This is better state management than keeping a counter.
                grid[newRow][newCol] = grid[currentRow][currentCol] + 1;
		        // Add next cell to queue.
                queue.add(new int[]{ newRow, newCol });
            }
        }
    }
}
