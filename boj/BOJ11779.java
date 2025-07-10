package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11779 {
    static FastReader SC = new FastReader();
    static int N, M, START, END;
    static ArrayList<Edge>[] EDGES;
    static int[] DIST;
    static int[] ROUTE; // 직전 노드 저장

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
        public int idx, weight;

        public Info() {

        }

        public Info(int _idx, int _weight) {
            this.idx = _idx;
            this.weight = _weight;
        }
    }

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        DIST = new int[N + 1];
        EDGES = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            EDGES[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            int from = SC.nextInt();
            int to = SC.nextInt();
            int weight = SC.nextInt();
            EDGES[from].add(new Edge(to, weight));
        }
        START = SC.nextInt();
        END = SC.nextInt();

        ROUTE = new int[N + 1];

        dijkstra(START);

        System.out.println(DIST[END]);

        ArrayList<Integer> routes = new ArrayList<>();
        int current = END;
        while (current != 0) {
            routes.add(current);
            current = ROUTE[current];
        }
        System.out.println(routes.size());
        for (int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }

    private static void dijkstra(int start) {
        for (int i = 1; i <= N; i++) {
            DIST[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        DIST[start] = 0;
        ROUTE[start] = 0;
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (info.weight != DIST[info.idx]) {
                continue;
            }

            for (Edge e : EDGES[info.idx]) {
                if (DIST[info.idx] + e.weight >= DIST[e.to]) {
                    continue;
                }

                DIST[e.to] = DIST[info.idx] + e.weight;
                ROUTE[e.to] = info.idx;
                pq.add(new Info(e.to, DIST[e.to]));
            }
        }
    }
}
