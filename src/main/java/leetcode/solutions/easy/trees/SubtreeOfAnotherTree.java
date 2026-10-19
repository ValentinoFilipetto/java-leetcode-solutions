package leetcode.solutions.easy.trees;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Trees (DFS)
 * Time complexity: O(n * m), where n is the size of root and m is the size of subRoot.
 * Space complexity: O(n)
 */

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot != null) return false;
        
        // If current trees are the same, return true immediately, otherwise check root's children against subRoot.
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
