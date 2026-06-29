package neetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphValidTree {
    public static void main(String[] args) {
        GraphValidTree sol = new GraphValidTree();
        boolean res = sol.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}});
        IO.println(res);
        res = sol.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}});
        IO.println(res);
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        if (!dfs(0, -1, visit, adj)) {
            return false;
        }
        return visit.size() == n;
    }

    private boolean dfs(int node, int parent, Set<Integer> visit, List<List<Integer>> adj) {
        if (visit.contains(node)) {
            return false;
        }
        visit.add(node);

        for (int elem : adj.get(node)) {
            if (elem == parent) {
                continue;
            }
            if (!dfs(elem, node, visit, adj)) {
                return false;
            }
        }
        return true;
    }


}
