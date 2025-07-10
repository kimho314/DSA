package boj;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ12761 {
    static FastReader SC = new FastReader();
    static int A, B, N, M;
    static boolean[] VISITED;
    static int[] DIST;

    public static void main(String[] args) {
        init();
        solve();
        System.out.println(DIST[M]);
    }

    private static void init() {
        A = SC.nextInt();
        B = SC.nextInt();
        N = SC.nextInt();
        M = SC.nextInt();
        VISITED = new boolean[100001];
        DIST = new int[100001];
    }

    private static void solve() {
        bfs(N);
    }

    private static void bfs(int start) {
        VISITED[start] = true;
        DIST[start] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int n = q.poll();

            int dn = n + 1;
            if (dn >= 0 && dn <= 100000 && !VISITED[dn]) {
                VISITED[dn] = true;
                DIST[dn] = DIST[n] + 1;
                q.add(dn);
            }

            dn = n - 1;
            if (dn >= 0 && dn <= 100000 && !VISITED[dn]) {
                VISITED[dn] = true;
                DIST[dn] = DIST[n] + 1;
                q.add(dn);
            }

            dn = n - A;
            if (dn >= 0 && dn <= 100000 && !VISITED[dn]) {
                VISITED[dn] = true;
                DIST[dn] = DIST[n] + 1;
                q.add(dn);
            }

            dn = n + A;
            if (dn >= 0 && dn <= 100000 && !VISITED[dn]) {
                VISITED[dn] = true;
                DIST[dn] = DIST[n] + 1;
                q.add(dn);
            }

            dn = n - B;
            if (dn >= 0 && dn <= 100000 && !VISITED[dn]) {
                VISITED[dn] = true;
                DIST[dn] = DIST[n] + 1;
                q.add(dn);
            }

            dn = n + B;
            if (dn >= 0 && dn <= 100000 && !VISITED[dn]) {
                VISITED[dn] = true;
                DIST[dn] = DIST[n] + 1;
                q.add(dn);
            }

            dn = n * A;
            if (dn >= 0 && dn <= 100000 && !VISITED[dn]) {
                VISITED[dn] = true;
                DIST[dn] = DIST[n] + 1;
                q.add(dn);
            }

            dn = n * B;
            if (dn >= 0 && dn <= 100000 && !VISITED[dn]) {
                VISITED[dn] = true;
                DIST[dn] = DIST[n] + 1;
                q.add(dn);
            }
        }
    }
}
