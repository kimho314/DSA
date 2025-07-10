package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ6118 {
    static FastReader SC = new FastReader();
    static int N, M;
    static boolean[] VISITED;
    static int[] DIST;
    static ArrayList<Integer>[] ADJ;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        VISITED = new boolean[N + 1];
        DIST = new int[N + 1];
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            ADJ[n1].add(n2);
            ADJ[n2].add(n1);
        }
        Arrays.fill(DIST, -1);

        bfs(1);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (DIST[i] > max) {
                max = DIST[i];
            }
        }

        int idx = 0;
        int cnt = 0;
        for (int i = N; i > 0; i--) {
            if (max == DIST[i]) {
                cnt++;
                idx = i;
            }
        }
        System.out.println(idx + " " + max + " " + cnt);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        VISITED[start] = true;
        DIST[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int x : ADJ[node]) {
                if (VISITED[x]) {
                    continue;
                }

                VISITED[x] = true;
                DIST[x] = DIST[node] + 1;
                q.add(x);
            }
        }
    }
}
