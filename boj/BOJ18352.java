package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ18352 {
    static FastReader SC = new FastReader();
    static int N, M, K, X;
    static int[] DIST;
    static boolean[] VISITED;
    static ArrayList<Integer>[] ADJ;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        K = SC.nextInt();
        X = SC.nextInt();
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        DIST = new int[N + 1];
        Arrays.fill(DIST, -1);
        VISITED = new boolean[N + 1];
        for (int i = 1; i <= M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            ADJ[n1].add(n2);
        }

        bfs(X);
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (DIST[i] == K) {
                SB.append(i).append('\n');
                cnt++;
            }
        }

        if (cnt == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(SB.toString());
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        VISITED[start] = true;
        DIST[start] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int n : ADJ[x]) {
                if (VISITED[n]) {
                    continue;
                }

                queue.add(n);
                VISITED[n] = true;
                DIST[n] = DIST[x] + 1;
            }
        }
    }
}
