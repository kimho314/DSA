package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ5014 {
    static FastReader SC = new FastReader();
    static int F, S, G, U, D;
    static int[] FLOORS;
    static boolean[] VISITED;
    static int[] DIST;

    public static void main(String[] args) {
        F = SC.nextInt();
        S = SC.nextInt();
        G = SC.nextInt();
        U = SC.nextInt();
        D = SC.nextInt();
        FLOORS = new int[F + 1];
        VISITED = new boolean[F + 1];
        DIST = new int[F + 1];
        Arrays.fill(DIST, -1);

        bfs(S);

        int dist = DIST[G];
        if (dist == -1) {
            System.out.println("use the stairs");
        }
        else {
            System.out.println(dist);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        VISITED[start] = true;
        DIST[start] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            int up = x + U;
            if (up >= 1 && up <= F && !VISITED[up]) {
                q.add(up);
                VISITED[up] = true;
                DIST[up] = DIST[x] + 1;
            }
            int down = x - D;
            if (down >= 1 && down <= F && !VISITED[down]) {
                q.add(down);
                VISITED[down] = true;
                DIST[down] = DIST[x] + 1;
            }
        }
    }
}
