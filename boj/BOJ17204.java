package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ17204 {
    static FastReader SC = new FastReader();
    static int N, K;
    static ArrayList<Integer>[] ADJ;
    static boolean[] VISITED;
    static int[] DIST;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.fill(DIST, -1);

        bfs(0);

        System.out.println(DIST[K]);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        VISITED[start] = true;
        DIST[start] = 0;

        while (!q.isEmpty()) {
            Integer n = q.poll();

            for (Integer dn : ADJ[n]) {
                if (VISITED[dn]) {
                    continue;
                }

                VISITED[dn] = true;
                DIST[dn] = DIST[n] + 1;
                q.add(dn);
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        ADJ = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        VISITED = new boolean[N];
        DIST = new int[N];

        for (int i = 0; i < N; i++) {
            int n = SC.nextInt();
            ADJ[i].add(n);
        }
    }
}
