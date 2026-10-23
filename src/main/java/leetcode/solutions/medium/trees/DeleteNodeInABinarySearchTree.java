package leetcode.solutions.medium.trees;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Trees (DFS)
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class DeleteNodeInABinarySearchTree {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            // Node found
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Two children: promote right subtree and attach left subtree
            TreeNode newRoot = root.right;
            TreeNode leftMost = newRoot;

            while (leftMost.left != null) leftMost = leftMost.left;

            leftMost.left = root.left;

            return newRoot;
        }
        return root;
    }
}
