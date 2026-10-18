package leetcode.solutions.easy.trees;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Trees (DFS)
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Note: we need a local max variable because of an edge case: when the diameter is not obtainable by connecting the left diameter 
 * with the right diameter through the root node, i.e. when the diameter is entirely contained and "isolated" in one of the two root subtrees.
 */

public class DiameterOfBinaryTree {
    int currMax = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return currMax;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int maxDepthLeft = root.left == null ? 0 : 1 + dfs(root.left);
        int maxDepthRight = root.right == null ? 0 : 1 + dfs(root.right);
        currMax = Math.max(currMax, maxDepthLeft + maxDepthRight);
        return Math.max(maxDepthLeft, maxDepthRight);
    }
}

