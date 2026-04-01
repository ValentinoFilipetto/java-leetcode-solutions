package leetcode.solutions.medium.tree;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: binary search trees
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class LowestCommonAncestorInBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If this is the case, p is on the left and q is on the right, or the other way around,
        // therefore root has to be the lowest common ancestor.
        if ((p.val < root.val && q.val > root.val) || (q.val < root.val && p.val > root.val)) {
            return root;
        }
        // Remember that p and q are not within the tree, so we cannot compare memory locations, but only values.
        if (p.val == root.val || q.val == root.val) return root;

        if (p.val < root.val) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}
