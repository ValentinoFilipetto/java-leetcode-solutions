package leetcode.solutions.easy.tree;

import leetcode.solutions.types.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Pattern: Tree (BFS)
 * Time complexity: O(n)
 * Space complexity: O(n), for queue.
 */

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return level;
    }
}
