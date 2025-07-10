package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ18232 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int S, E;
    private static ArrayList<Integer>[] ADJ;
    private static boolean[] VISITED;
    private static int[] DIST;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        bfs(S);
        System.out.println(DIST[E]);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        VISITED[start] = true;
        DIST[start] = 0;

        while (!q.isEmpty()) {
            int n = q.poll();

            for (Integer x : ADJ[n]) {
                if (!VISITED[x]) {
                    VISITED[x] = true;
                    DIST[x] = DIST[n] + 1;
                    q.add(x);
                }
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        S = SC.nextInt();
        E = SC.nextInt();
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        VISITED = new boolean[N + 1];
        for (int i = 1; i < N; i++) {
            ADJ[i].add(i + 1);
            ADJ[i + 1].add(i);
        }
        for (int i = 0; i < M; i++) {
            int x = SC.nextInt();
            int y = SC.nextInt();
            ADJ[x].add(y);
            ADJ[y].add(x);
        }
        DIST = new int[N + 1];
    }
}
