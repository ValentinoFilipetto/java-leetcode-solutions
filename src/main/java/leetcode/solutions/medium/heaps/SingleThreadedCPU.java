package leetcode.solutions.medium.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Pattern: min-heap
 * Time complexity: O(n log n), where n is the number of tasks.
 * Space complexity: O(n), as we are storing all tasks in two heaps.
 * Intuition: we use two min-heaps:
 * - one stores the tasks we can process right now,
 * - the other stores the tasks that are too early to process.
 * min-heaps also manage priorities effectively.
 * At every iteration, we poll from minHeap to see if something is available.
 * 
 * You may ask: why use two min-heaps? Are we not adding unnecessary complexity?
 * If we store everything in a single min-heap, we will need to give biggest priority
 * to enqueueTime, but that will give us wrong processing order of tasks in some cases,
 * e.g. if a task has earlier enqueue time but longer processing time.
*/

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        // [index, enqueueTime, processingTime]
        // Sort in increasing order by enqueueTime.
        // This contains tasks that we cannot process yet as it is too early.
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            Comparator.comparingInt((int[] a) -> a[1])
        );
        // [index, enqueueTime, processingTime]
        // Sort in increasing order by processingTime first, then by index.
        // This contains tasks that can be processed *right now*.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt((int[] a) -> a[2])
                          .thenComparingInt(a -> a[0])
        );
        
        // Add all tasks to queue, including index, as we have to return it later
        // and it can determine tasks priorities.
        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            queue.offer(new int[]{ i, task[0], task[1] });
        }

        int[] res = new int[tasks.length];
        int time = 1;
        int index = 0;
        while (!queue.isEmpty() || !minHeap.isEmpty()) {
            // If no tasks is available for processing, jump ahead in time.
            // Without this jump, minHeap.poll() can return null.
            if (minHeap.isEmpty()) {
                // Math.max() avoids moving time backward when the next task was enqueued 
                // before the current task finished.
                time = Math.max(time, queue.peek()[1]);
            }
            
            // Add tasks to minHeap from queue, as long as it is time to process them.
            while (!queue.isEmpty() && queue.peek()[1] <= time) {
                minHeap.offer(queue.poll());
            }
        
            int[] task = minHeap.poll();
            res[index] = task[0];
            time += task[2];
            index++;
        }
        return res;
    }
}