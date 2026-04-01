package leetcode.solutions.medium.tree;

import leetcode.solutions.types.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Pattern: Trees (BFS)
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // Remember to extract queue size *before* getting into the loop!
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(level);
        }
        return res;
    }
}
