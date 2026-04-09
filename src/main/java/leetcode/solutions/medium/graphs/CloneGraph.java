package leetcode.solutions.medium.graphs;

import leetcode.solutions.types.GraphNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
	
/**
 * Pattern: Graphs (DFS)
 * Time complexity: O(V + E)
 * Space complexity: O(V), as we store vertices in a hash map.
 * Note: this algorithm creates a `deep copy` of the original graph: all nodes and edges
 * are recreated at different memory locations.
 */

public class CloneGraph {
    Map<GraphNode, GraphNode> oldToNew;
    public GraphNode cloneGraph(GraphNode node) {
	    // This hash map contains pairs of <reference to old node, reference to copy>.
        oldToNew = new HashMap<>();

        // This allows us to avoid a null check in dfs().
	    // If node is null, simply return null in the base case.
        oldToNew.put(null, null);

        dfs(node);
	    // By default, we return the starting node.
        return oldToNew.get(node);
    }

    private GraphNode dfs(GraphNode node) {
	    // With this base we do not get stuck in loops:
	    // If something has been already `seen`, we find it here.
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }

        GraphNode clone = new GraphNode(node.val);
        oldToNew.put(node, clone);
        List<GraphNode> neighbors = node.neighbors;
        for (GraphNode n : neighbors) {
            clone.neighbors.add(dfs(n));
        }
        return clone;
    }
}
