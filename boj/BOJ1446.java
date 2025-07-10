package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ1446 {
    static FastReader SC = new FastReader();
    static int N, D;
    static int[] DIST;
    static ArrayList<Edge>[] EDGES;

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

        public Info(int _idx, int _dist) {
            this.idx = _idx;
            this.dist = _dist;
        }
    }

    public static void main(String[] args) {
        N = SC.nextInt();
        D = SC.nextInt();
        EDGES = new ArrayList[10001];
        for (int i = 0; i < 10001; i++) {
            EDGES[i] = new ArrayList<>();
        }

        DIST = new int[10001];

        for (int i = 0; i < 10001 - 1; i++) {
            EDGES[i].add(new Edge(i + 1, 1));
        }
        for (int i = 0; i < N; i++) {
            int from = SC.nextInt();
            int to = SC.nextInt();
            int weight = SC.nextInt();
            EDGES[from].add(new Edge(to, weight));
        }

        dijkstra(0);
        System.out.println(DIST[D]);
    }

    private static void dijkstra(int start) {
        for (int i = 0; i < 10001; i++) {
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
                if (DIST[e.to] <= DIST[info.idx] + e.weight) {
                    continue;
                }

                DIST[e.to] = DIST[info.idx] + e.weight;
                pq.add(new Info(e.to, DIST[e.to]));
            }
        }
    }
}
