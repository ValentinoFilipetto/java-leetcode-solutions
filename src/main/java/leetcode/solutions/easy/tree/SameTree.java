package leetcode.solutions.easy.tree;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Trees
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
