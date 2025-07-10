package boj;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ25418 {
    static FastReader SC = new FastReader();
    static int N, K;
    static boolean[] VISITED;
    static int[] DIST;

    public static void main(String[] args) {
        N = SC.nextInt();
        K = SC.nextInt();
        VISITED = new boolean[1000001];
        DIST = new int[1000001];

        bfs(N);
        System.out.println(DIST[K]);
    }

    private static void bfs(int start) {
        VISITED[start] = true;
        DIST[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int i = 0; i < 2; i++) {
                int dx = x;
                if (i == 0) {
                    dx = dx + 1;
                }
                if (i == 1) {
                    dx = dx * 2;
                }

                if (dx <= 0 || dx > 1000000) {
                    continue;
                }
                if (VISITED[dx]) {
                    continue;
                }


                VISITED[dx] = true;
                DIST[dx] = DIST[x] + 1;
                q.add(dx);
            }
        }

    }
}
