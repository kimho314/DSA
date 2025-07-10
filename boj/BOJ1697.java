package boj;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ1697 {
    static FastReader sc = new FastReader();
    static int N, K;
    static int[] DIST;
    static boolean[] VISITED;

    public static void main(String[] args) {
        N = sc.nextInt();
        K = sc.nextInt();
        VISITED = new boolean[100001];
        DIST = new int[100001];

        bfs();
        System.out.println(DIST[K]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        VISITED[N] = true;
        DIST[N] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int i = 0; i < 3; i++) {
                int dx = x;
                if (i == 0) {
                    dx = 2 * dx;
                }
                if (i == 1) {
                    dx = dx + 1;
                }
                if (i == 2) {
                    dx = dx - 1;
                }

                if (dx < 0 || dx > 100000) {
                    continue;
                }
                if (VISITED[dx]) {
                    continue;
                }

                DIST[dx] = DIST[x] + 1;
                VISITED[dx] = true;
                q.add(dx);
            }
        }
    }
}
