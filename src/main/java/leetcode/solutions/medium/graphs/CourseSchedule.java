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

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
	    // Add an array for each course/node in the graph.
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
	
	    // For each node, store in graph the nodes I can reach from there,
	    // and keep track of indegrees.
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
	
	    // Add indegree-0 nodes to queue.
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int processed = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            processed++;
	    
	        // Check all `next` nodes from course and decrement its indegree.
            for (int next : adj.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
	
	    // If we could process all the nodes in the graph, the graph has no cycles,
	    // hence we can take all the courses.
        return processed == numCourses;
    }
}
