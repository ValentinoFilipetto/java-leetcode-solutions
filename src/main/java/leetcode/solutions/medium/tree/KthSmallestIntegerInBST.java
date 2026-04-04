package leetcode.solutions.medium.tree;

import leetcode.solutions.types.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern: Trees (DFS)
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Note: inorder traversal in a binary search tree yields values in increasing order.
 */

public class KthSmallestIntegerInBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        dfs(root, list);
        // k is 1-indexed.
        return list.get(k - 1);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;

        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
