package leetcode.solutions.medium.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Pattern: min-heap
 * Time complexity: O(n log n), where n is the number of trips.
 * Space complexity: O(n)
 * Intuition: we use two min-heaps, one to gain fast access to the next trip in line and another to let passengers leave when it is time.
 */

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        // Keeps track of who is still waiting to be picked up.
        // Sorted by who is closer to the current position.
        // [numPassengers, from, to]
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );
        // Keeps track of who is currently in the car.
        // Who leaves earlier comes first.
        // [numPassengers, from, to]
        PriorityQueue<int[]> currentRide = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );
    
        Arrays.stream(trips).forEach(queue::offer);
        int currentLoad = 0;
        int currentPosition = 0;

        while (!queue.isEmpty()) {
            // Jump to the next position to save time.
            currentPosition = queue.peek()[1];

            // If someone arrived, decrease current capacity.
            while (!currentRide.isEmpty() && currentPosition >= currentRide.peek()[2]) {
                currentLoad -= currentRide.poll()[0];
            }

            // If someone can join, increase current capacity.
            while (!queue.isEmpty() && currentPosition == queue.peek()[1]) {
                // Not enough capacity, return false.
                if (queue.peek()[0] + currentLoad > capacity) return false;
                currentLoad += queue.peek()[0];
                currentRide.offer(queue.poll());
            }
        }
        return true;
    }
}
