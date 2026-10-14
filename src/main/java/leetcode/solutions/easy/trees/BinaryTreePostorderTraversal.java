package leetcode.solutions.easy.trees;

import java.util.ArrayList;
import java.util.List;

import leetcode.solutions.types.TreeNode;

/**
 * Pattern: Trees
 * Time complexity: O(n), where n is the number of nodes in the tree.
 * Space complexity: O(n), for the recursion stack.
 */

public class BinaryTreePostorderTraversal {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        dfs(root.right);
        res.add(root.val);
    }
}
