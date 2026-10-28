package leetcode.solutions.medium.trees;

import leetcode.solutions.types.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern: Trees (DFS)
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Explanation: in-order traversal in a BST yields values in increasing order.
 */

public class KthSmallestIntegerInBST {
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        // k is 1-indexed.
        return list.get(k - 1);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
