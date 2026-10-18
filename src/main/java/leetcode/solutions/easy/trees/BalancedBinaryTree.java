package leetcode.solutions.easy.trees;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Trees
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Note: our recursive function returns [isBalanced = [0, 1], depth of tree rooted at that node]
 * We could use a global isBalanced variable instead, but it is cleaner to have no shared state between recursive calls.
 */

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        int[] res = dfs(root);
        return res[1] == 1;
    }

    // int[] = [depth, isSubtreeBalanced]
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[] { 0, 1 };
        
        int[] resLeft = dfs(root.left);
        int[] resRight = dfs(root.right);
        
        int isBalanced = 1;
        if (resLeft[1] == 0 || resRight[1] == 0) isBalanced = 0;
        if (Math.abs(resLeft[0] - resRight[0]) > 1) isBalanced = 0;
        int heigth = 1 + Math.max(resLeft[0], resRight[0]);

        return new int[] { heigth, isBalanced };
    }
}
