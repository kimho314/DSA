package boj;

import java.util.*;

public class BOJ13549 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static boolean[] VISITED;
    private static int[] DIST;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        VISITED = new boolean[100_001];
        DIST = new int[100_001];
    }

    private static void solve() {
        bfs(N);

        System.out.println(DIST[K]);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        VISITED[start] = true;
        DIST[start] = 0;

        while (!q.isEmpty()) {
            int n = q.poll();

            int dn = 2 * n;
            if (dn >= 0 && dn <= 100_000 && !VISITED[dn]) {
                VISITED[dn] = true;
                DIST[dn] = DIST[n];
                q.add(dn);
            }
            dn = n - 1;
            if (dn >= 0 && dn <= 100_000 && !VISITED[dn]) {
                VISITED[dn] = true;
                DIST[dn] = DIST[n] + 1;
                q.add(dn);
            }
            dn = n + 1;
            if (dn >= 0 && dn <= 100_000 && !VISITED[dn]) {
                VISITED[dn] = true;
                DIST[dn] = DIST[n] + 1;
                q.add(dn);
            }

        }
    }
}
