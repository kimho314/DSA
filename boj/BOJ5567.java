package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ5567 {
    static FastReader SC = new FastReader();
    static int N, M;
    static ArrayList<Integer>[] ADJ;
    static boolean[] VISITED;
    static int[] DIST;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        VISITED = new boolean[N + 1];
        DIST = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int a = SC.nextInt();
            int b = SC.nextInt();
            ADJ[a].add(b);
            ADJ[b].add(a);
        }

        bfs(1);
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (DIST[i] > 0 && DIST[i] <= 2) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        VISITED[start] = true;
        DIST[start] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : ADJ[x]) {
                if (VISITED[y]) {
                    continue;
                }

                VISITED[y] = true;
                DIST[y] = DIST[x] + 1;
                q.add(y);
            }
        }
    }
}
