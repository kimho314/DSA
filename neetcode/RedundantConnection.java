package neetcode;

import java.util.*;

public class RedundantConnection {
    public static void main(String[] args) {
        RedundantConnection sol = new RedundantConnection();
        int[] res = sol.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {3, 4}, {2, 4}}); // [2,4]
        IO.println(Arrays.toString(res));
        res = sol.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}}); // [3,4]
        IO.println(Arrays.toString(res));
        res = sol.findRedundantConnection(new int[][]{{2, 7}, {7, 8}, {3, 6}, {2, 5}, {6, 8}, {4, 8}, {2, 8}, {1, 8}, {7, 10}, {3, 9}}); // [2,8]
        IO.println(Arrays.toString(res));
    }

    private int cycleStart;
    private List<List<Integer>> adj;
    private boolean[] visit;
    private Set<Integer> cycle;

    public int[] findRedundantConnection2(int[][] edges) {
        int n = edges.length;
        adj = new ArrayList<>();
        cycleStart = -1;
        visit = new boolean[n + 1];
        cycle = new HashSet<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs2(1, -1);

        for (int i = n - 1; i >= 0; i--) {
            if (cycle.contains(edges[i][0]) && cycle.contains(edges[i][1])) {
                return new int[]{edges[i][0], edges[i][1]};
            }
        }
        return new int[0];
    }

    private boolean dfs2(int node, int parent) {
        if (visit[node]) {
            cycleStart = node;
            return true;
        }
        visit[node] = true;
        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (dfs2(nei, node)) {
                if (cycleStart != -1) {
                    cycle.add(node);
                }
                if (node == cycleStart) {
                    cycleStart = -1;
                }
                return true;
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);

            boolean[] visit = new boolean[n + 1];
            if (dfs(u, -1, adj, visit)) {
                return edge;
            }
        }
        return new int[0];
    }

    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visit) {
        if (visit[node]) {
            return true;
        }
        visit[node] = true;

        for (int elem : adj.get(node)) {
            if (elem == parent) {
                continue;
            }
            if (dfs(elem, node, adj, visit)) {
                return true;
            }
        }
        return false;
    }


}
