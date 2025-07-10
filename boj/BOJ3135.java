package boj;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ3135 {
    static FastReader SC = new FastReader();
    static int A, B, N;
    static int[] FRQ;
    static int[] MAP = new int[1001];
    static boolean[] VISITED = new boolean[1001];
    static int[] DIST = new int[1001];

    public static void main(String[] args) {
        A = SC.nextInt();
        B = SC.nextInt();
        N = SC.nextInt();
        FRQ = new int[N];
        for (int i = 0; i < N; i++) {
            FRQ[i] = SC.nextInt();
        }

        bfs(A);
        System.out.println(DIST[B]);
    }

    private static void bfs(int start) {
        DIST[start] = 0;
        VISITED[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int x = q.poll();

            int dx = x + 1;
            if (dx > 0 && dx <= 1000 && !VISITED[dx]) {
                DIST[dx] = DIST[x] + 1;
                VISITED[dx] = true;
                q.add(dx);
            }
            dx = x - 1;
            if (dx > 0 && dx <= 1000 && !VISITED[dx]) {
                DIST[dx] = DIST[x] + 1;
                VISITED[dx] = true;
                q.add(dx);
            }
            for (int i = 0; i < N; i++) {
                dx = FRQ[i];
                if (dx > 0 && dx <= 1000 && !VISITED[dx]) {
                    DIST[dx] = DIST[x] + 1;
                    VISITED[dx] = true;
                    q.add(dx);
                }
            }
        }
    }
}
