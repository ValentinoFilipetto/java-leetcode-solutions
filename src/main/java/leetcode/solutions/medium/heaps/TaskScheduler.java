package leetcode.solutions.medium.heaps;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Pattern: max-heap
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Intuition:
 * We could think that time complexity is O(n log k), where n is the number of tasks and k is the number of distinct task types,
 * with k <= 26. But because k is constant, we end up with O(n) and constant space complexity.
 */

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for (char task : tasks) count[task - 'A']++;

        // This max-heap gives us the most frequent task among the *available* ones.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Store frequencies of each task.
        for (int cnt : count) if (cnt > 0) maxHeap.add(cnt);
            
        int time = 0;
        // This queue keeps the tasks that are in "cooldown state".
        // For each task, we save count and availability time.
        Queue<int[]> q = new LinkedList<>();
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            // if maxHeap.isEmpty(), it means that no task is available, so we can only sit idle,
            // so we jump directly to the next available time slot. This is a key optimization that gives us O(n) time complexity,
            // where n is the amount of tasks.
            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    q.add(new int[] { cnt, time + n });
                }
            }
            
            // If the next task in the queue is available, add it to the max-heap.
            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }
}
