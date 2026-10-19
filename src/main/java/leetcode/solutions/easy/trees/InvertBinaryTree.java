package leetcode.solutions.easy.trees;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Trees (DFS)
 * Time complexity: O(n)
 * Space complexity: O(n) for recursion stack.
 */

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}
