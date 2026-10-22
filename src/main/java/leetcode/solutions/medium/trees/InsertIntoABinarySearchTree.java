package leetcode.solutions.medium.trees;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Trees (DFS)
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // If root is null, just return the new node alone.
        if (root == null) return new TreeNode(val);
        dfs(root, val);
        return root;
    }

    private void dfs(TreeNode root, int val) {
        if (val < root.val) {
            if (root.left != null) dfs(root.left, val);
            else root.left = new TreeNode(val);
        } 

        if (val > root.val) {
            if (root.right != null) dfs(root.right, val);
            else root.right = new TreeNode(val);
        } 
    }
}
