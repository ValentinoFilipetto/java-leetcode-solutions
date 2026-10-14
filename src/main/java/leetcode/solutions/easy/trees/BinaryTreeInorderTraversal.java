package leetcode.solutions.easy.trees;

import java.util.ArrayList;
import java.util.List;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Trees
 * Time complexity: O(n), where n is the number of nodes in the tree.
 * Space complexity: O(n), for the recursion stack.
 */


public class BinaryTreeInorderTraversal {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
