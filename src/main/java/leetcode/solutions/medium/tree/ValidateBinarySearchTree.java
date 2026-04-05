package leetcode.solutions.medium.tree;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Trees (DFS)
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        int[] res = dfs(root);
        return res[2] == 1;
    }

    /** Returns [ minRight, maxLeft, isValid ] */
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{ Integer.MAX_VALUE, Integer.MIN_VALUE, 1 };

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // if left/right subtree invalid → propagate invalidity.
        if (left[2] == 0 || right[2] == 0) return new int[]{ 0, 0, 0 };

        // BST property check. If invalid → propagate invalidity.
        if (!(left[1] < root.val && root.val < right[0])) {
            return new int[]{ 0, 0, 0 };
        }

        // When calculating, say, min, we do not need to compare left[0], right[0] and root because
        // we already know that right[0] is bigger than root, otherwise we would have returned already above.
        // Same holds, respectively, for max.
        int min = Math.min(left[0], root.val);
        int max = Math.max(right[1], root.val);

        return new int[]{ min, max, 1 };
    }
}
