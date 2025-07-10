package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ1753 {
    static FastReader SC = new FastReader();

    static class Edge {
        public int to, weight;

        public Edge() {

        }

        public Edge(int _to, int _weight) {
            this.to = _to;
            this.weight = _weight;
        }
    }

    static class Info {
        public int idx, dist;

        public Info() {

        }

        public Info(int _idx, int dist) {
            this.idx = _idx;
            this.dist = dist;
        }
    }

    static int V, E;
    static int START;
    static ArrayList<Edge>[] EDGES;
    static int[] DIST;

    public static void main(String[] args) {
        V = SC.nextInt();
        E = SC.nextInt();
        START = SC.nextInt();
        DIST = new int[V + 1];
        EDGES = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            EDGES[i] = new ArrayList<>();
        }
        for (int i = 1; i <= E; i++) {
            int u = SC.nextInt();
            int v = SC.nextInt();
            int w = SC.nextInt();
            EDGES[u].add(new Edge(v, w));
        }

        dijkstra(START);
        for (int i = 1; i <= V; i++) {
            if (DIST[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(DIST[i]);
            }
        }
    }

    private static void dijkstra(int start) {
        for (int i = 1; i <= V; i++) {
            DIST[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        pq.add(new Info(start, 0));
        DIST[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (DIST[info.idx] != info.dist) {
                continue;
            }

            for (Edge e : EDGES[info.idx]) {
                if (DIST[info.idx] + e.weight >= DIST[e.to]) {
                    continue;
                }

                DIST[e.to] = DIST[info.idx] + e.weight;
                pq.add(new Info(e.to, DIST[e.to]));
            }
        }
    }
}
