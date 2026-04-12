package leetcode.solutions.medium.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Pattern: Graphs (Topological Sort, Kahn's algorithm)
 * Time complexity: O(V + E)
 * Space complexity: O(V + E)
 */

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegrees[p[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }

        int[] res = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[i] = course;
            i++;
            List<Integer> neighbors = adj.get(course);
            for (Integer next : neighbors) {
                indegrees[next]--;
                if (indegrees[next] == 0) queue.add(next);
            }
        }
        // If we were able to add all the courses, return the path, otherwise empty array.
        return i == numCourses ? res : new int[]{};
    }
}
