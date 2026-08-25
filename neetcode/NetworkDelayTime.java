package neetcode;


import java.util.*;

public class NetworkDelayTime {
    static void main() {
        NetworkDelayTime sol = new NetworkDelayTime();
        int res = sol.networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 1}, {1, 4, 4}, {3, 4, 1}}, 4, 1);
        IO.println(res);
        res = sol.networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 1}}, 3, 2);
        IO.println(res);
    }

    private static class Edge {
        public int to;
        public int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int w = time[2];
            graph.get(from).add(new Edge(to, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});
        Set<Integer> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int d = cur[1];

            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);

            for (Edge edge : graph.get(node)) {
                int newDist = d + edge.weight;
                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    pq.offer(new int[]{edge.to, newDist});
                }
            }
        }

        if (visited.size() != n) {
            return -1;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}
