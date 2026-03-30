package leetcode.solutions.easy.tree;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Tree (DFS)
 * Time complexity: O(n)
 * Space complexity: O(n), due to recursion stack.
 */

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
