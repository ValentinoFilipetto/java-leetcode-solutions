package leetcode.solutions.hard.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Time complexity: addNum() takes O(log n) while findMedian() takes O(1), where n is the total number of nums processed.
 * Space complexity: O(n)
 * Note: the reason why we tolerate a difference of at most 1 in heap size is that if n is a odd number, we cannot help but
 * having a difference of one in the two heaps. But more than 1 would not yield the correct median result.
 */

public class FindMedianFromDataStream {
    private Queue<Integer> smallHeap; // Small elements - maxHeap
    private Queue<Integer> largeHeap; // Large elements - minHeap

    public FindMedianFromDataStream() {
        // Integer.compare() avoids overflow.
        smallHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        largeHeap = new PriorityQueue<>();
    }

    /* Add num to the correct heap. */
    public void addNum(int num) {
        smallHeap.add(num);
        if (
            smallHeap.size() - largeHeap.size() > 1 ||
            !largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()
        ) {
            largeHeap.add(smallHeap.poll());
        }
        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }
    }

    /*
    * Returns median value in the stream.
    * Note that (double) casting is needed only on line 35, as we perform a division,
    * but not on lines 45 and 45, as an implicit conversion happens there. */
    public double findMedian() {
        if (smallHeap.size() == largeHeap.size()) {
            return (double) (largeHeap.peek() + smallHeap.peek()) / 2;
        } else if (smallHeap.size() > largeHeap.size()) {
            return smallHeap.peek();
        } else return largeHeap.peek();
    }
}