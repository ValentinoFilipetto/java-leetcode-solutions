package leetcode.solutions.easy.tree;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Trees
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Note: our recursive function returns [isBalanced = [0, 1], depth of tree rooted at that node]
 * We could use a global isBalanced variable instead, but it is cleaner to have no sahred state
 * between recursive calls and have everything in boolean[] balanced.
 */

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{1, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balanced = ((left[0] == 1) && (right[0] == 1)) && Math.abs(left[1] - right[1]) <= 1;
        return new int[]{balanced ? 1 : 0, 1 + Math.max(left[1], right[1])};
    }
}
