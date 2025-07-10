package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14496 {
    static FastReader SC = new FastReader();
    static int A, B;
    static int N, M;
    static ArrayList<Integer>[] ADJ;
    static boolean[] VISITED;
    static int[] DIST;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.fill(DIST, -1);

        bfs(A);

        System.out.println(DIST[B]);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        VISITED[start] = true;
        DIST[start] = 0;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int x : ADJ[n]) {
                if (!VISITED[x]) {
                    queue.add(x);
                    VISITED[x] = true;
                    DIST[x] = DIST[n] + 1;
                }
            }
        }
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
        N = SC.nextInt();
        M = SC.nextInt();
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        VISITED = new boolean[N + 1];
        DIST = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            ADJ[n1].add(n2);
            ADJ[n2].add(n1);
        }
    }
}
