package leetcode.solutions.easy.tree;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Tree (DFS)
 * Time complexity: O(n)
 * Space complexity: O(n) for recursion stack.
 */

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        root.left = this.invertTree(root.left);
        root.right = this.invertTree(root.right);
        return root;
    }
}
