package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1326 {
    private static FastReader SC = new FastReader();
    private static int N, A, B;
    private static int[] BRIDGES;
    private static boolean[] VISITED;
    private static int[] DIST;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        bfs(A);
//        for (int i = 1; i <= N; i++) {
//            System.out.println(DIST[i]);
//        }
//        System.out.println();
        System.out.println(DIST[B]);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        VISITED[start] = true;
        DIST[start] = 0;

        while (!q.isEmpty()) {
            Integer n = q.poll();
            for (int i = 1; i <= 10_000; i++) {
                int dx = (BRIDGES[n] * i) + n;
                if (dx > N) {
                    break;
                }
                if (VISITED[dx]) {
                    continue;
                }

                VISITED[dx] = true;
                DIST[dx] = DIST[n] + 1;
                q.add(dx);
            }

            for (int i = 1; i <= 10_000; i++) {
                int dx = n - (BRIDGES[n] * i);
                if (dx < 1) {
                    break;
                }
                if (VISITED[dx]) {
                    continue;
                }

                VISITED[dx] = true;
                DIST[dx] = DIST[n] + 1;
                q.add(dx);
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        BRIDGES = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            BRIDGES[i] = SC.nextInt();
        }
        VISITED = new boolean[N + 1];
        DIST = new int[N + 1];
        Arrays.fill(DIST, -1);
        A = SC.nextInt();
        B = SC.nextInt();
    }
}
