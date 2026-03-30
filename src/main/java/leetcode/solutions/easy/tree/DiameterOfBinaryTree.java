package leetcode.solutions.easy.tree;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Trees
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Note: we need a local max variable because of an edge case: when the diameter is not obtainable by
 * connecting the left diameter with the right diameter through the root node, i.e. when the diameter is entirely
 * contained and "isolated" in one of the two root subtrees.
 * To understand this solution, a drawing will be quite helpful.
 */

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        // We use int[] because we need a mutable reference as "current max" variable.
        // There are other possibilities but int[] is lightweight and idiomatic for coding interviews.
        int[] diameter = new int[1];
        dfs(root, diameter);
        return diameter[0];
    }

    private int dfs(TreeNode root, int[] diameter) {
        if (root == null) return 0;

        int left = dfs(root.left, diameter);
        int right = dfs(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        // We return the maximum value because we need to pick: we cannot
        // go up in the three by taking the sum of both subtrees.
        return 1 + Math.max(left, right);
    }
}

