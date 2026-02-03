import java.util.*;

public class RedundantConnection {
    public static void main(String[] args) {
        RedundantConnection sol = new RedundantConnection();
        int[] res = sol.findRedundantConnection(new int[][] {{1, 2}, {1, 3}, {3, 4}, {2, 4}});
        IO.println(Arrays.toString(res));
        res = sol.findRedundantConnection(new int[][] {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}});
        IO.println(Arrays.toString(res));
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

            boolean[] visited = new boolean[n + 1];
            if (dfs(u, -1, adj, visited)) {
                return edge;
            }
        }
        return new int[0];
    }

    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        if (visited[node]) {
            return true;
        }

        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (dfs(nei, node, adj, visited)) {
                return true;
            }
        }
        return false;
    }
}
