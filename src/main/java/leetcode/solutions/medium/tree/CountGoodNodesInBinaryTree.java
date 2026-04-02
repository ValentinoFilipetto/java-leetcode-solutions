package leetcode.solutions.medium.tree;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Trees (DFS)
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int maxSoFar) {
        if (root == null) return 0;

        int toAdd = maxSoFar <= root.val ? 1 : 0;
        maxSoFar = Math.max(maxSoFar, root.val);
        return toAdd + dfs(root.left, maxSoFar) + dfs(root.right, maxSoFar);
    }
}
