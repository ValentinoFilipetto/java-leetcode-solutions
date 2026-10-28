package leetcode.solutions.medium.trees;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Trees (DFS)
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Notes: 
 * - We use type long because there is an edge case where values of nodes are Integer.MAX_VALUE/Integer.MIN_VALUE.
 * - Double Math.max()/Math.min() on lines 27/28 are needed for trees like this:
 * 
 *       9
 *      / \
 *     6   15
 *    / \  / \
 *   3  16 10 20
 * 
 * Left and right subtrees of 9 are valid BSTs, but without the double Math.max() we would arrive at 9 and have 6 instead of 16 as max value.
 * That would make us flag the aforementioned tree as valid (6 < 9 < 20) while in fact it isn't.
 */

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root)[2] == 1;
    }
    
    // long[] = { maxLeft, minRight, isValid }
    private long[] dfs(TreeNode root) {
        if (root == null) return new long[] { Long.MIN_VALUE, Long.MAX_VALUE, 1 };

        long[] left = dfs(root.left);
        long[] right = dfs(root.right);

        long isValid = (left[0] < root.val && root.val < right[1]) && left[2] == 1 && right[2] == 1 ? 1 : 0;
        long max = Math.max(root.val, Math.max(left[0], right[0]));
        long min = Math.min(root.val, Math.min(left[1], right[1]));

        return new long[] { max, min, isValid };
    }
}
