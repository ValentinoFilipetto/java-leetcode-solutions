package leetcode.solutions.medium.tree;

import leetcode.solutions.types.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

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
            res.add(level.get(level.size() - 1));
        }
        return res;
    }
}
