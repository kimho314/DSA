import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraph sol =
                new NumberOfConnectedComponentsInAnUndirectedGraph();
        int res = sol.countComponents(5, new int[][] {{0, 1}, {1, 2}, {3, 4}});
        IO.println(res);
        res = sol.countComponents(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}});
        IO.println(res);
    }

    public int countComponents(int n, int[][] edges) {
        if (n == 0 || edges[0].length == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int res = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                res++;
            }
        }

        return res;
    }

    private void dfs(int x, List<List<Integer>> adj, boolean[] visited) {
        visited[x] = true;

        for (Integer node : adj.get(x)) {
            if (visited[node]) {
                continue;
            }

            dfs(node, adj, visited);
        }
    }
}
