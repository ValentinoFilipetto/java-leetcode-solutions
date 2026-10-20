package leetcode.solutions.medium.trees;

import leetcode.solutions.types.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Pattern: Trees (BFS)
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // For queues, ArrayDeque is more memory-efficient than LinkedList.
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null) return res;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            res.add(new ArrayList<>());

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                res.get(res.size() - 1).add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }
}
