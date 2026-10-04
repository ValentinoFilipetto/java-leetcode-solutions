package leetcode.solutions.hard.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Pattern: backtracking (DFS)
 * Time complexity: O(n!)
 * Space complexity: O(n^2)
 * Intuition: we need to place one queen per row, top to bottom.
 * For each cell in a row, if placing a queen in that cell creates a conflict with another (already placed above) queen,
 * skip that cell and advance on the right. Otherwise, place a queen on that cell and recurse on the next row, as we are done for the
 * current row.
 * Backtracking guarantees correct solutions and that eventually we collect all of them, as the problem statement requires.
 * Only placing queen correctly guarantees an advance to the next row, which is why we know that when we reach r == board.legnth, we *must*
 * have created a correct solution that needs to be added to the final response.
 */

public class NQueens {
    Set<Integer> col = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(0, board);
        return res;
    }

    private void backtrack(int r, char[][] board) {
        if (r == board.length) {
            res.add(new ArrayList<>());
            for (char[] row : board) {
                res.get(res.size() - 1).add(new String(row));
            }
            return;
        }

        for (int c = 0; c < board.length; c++) {
            // Check if placing the queen at (r, c) creates a conflict
            // with an already placed queen.
            if (col.contains(c) ||
                negDiag.contains(r - c) ||
                posDiag.contains(r + c)) {
                    continue;
                }
            
            // If not, place a queen and recurse to the next row (r + 1)
            col.add(c);
            negDiag.add(r - c);
            posDiag.add(r + c);
            board[r][c] = 'Q';
            backtrack(r + 1, board);
            col.remove(c);
            negDiag.remove(r - c);
            posDiag.remove(r + c);
            board[r][c] = '.';
        }
    }
}
