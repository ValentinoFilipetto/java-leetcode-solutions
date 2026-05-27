package leetcode.solutions.medium.graphs;

/**
 * Pattern: Graphs (Disjoint Set Union)
 * Time complexity: O(V + E * α(n)) = O(V + E) in practice, where α is the inverse Ackermann function
 *     - Initialization: O(V) to create parents and size arrays in DSU constructor.
 *     - Processing edges: O(E * α(n)) - iterate through E edges, each union does 2 finds
 *     - With path compression (in find) + union by size (in union), each find is O(α(n)) amortized
 *     - α(n) ≤ 5 for all practical values of n, so effectively O(V + E) in practice
 * Space complexity: O(V)
 * Intuition: every time we can successfully unify two nodes, we know we have one connected component
 * less than before.
 */

class DisjointSetUnion {
    int components;
    int[] parents;
    int[] sizes;

    public DisjointSetUnion(int n) {
        components = n;
        parents = new int[n];
        sizes = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }
    }

    public int find(int node) {
        if (node != parents[node]) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }

    public void union(int v, int u) {
        int pv = find(v);
        int pu = find(u);

        // We return here because, in this case, v and u
        // are already in the same connected component.
        if (pv == pu) return;

        if (sizes[pu] < sizes[pv]) {
            parents[pu] = pv;
            sizes[pv] += sizes[pu];
        } else {
            parents[pv] = pu;
            sizes[pu] += sizes[pv];
        }
        this.components--;
    }

    public int getComponents() {
        return this.components;
    }
}

public class NumberOfConnectedComponentsInUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        DisjointSetUnion dsu = new DisjointSetUnion(n);

        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        return dsu.getComponents();
    }
}
