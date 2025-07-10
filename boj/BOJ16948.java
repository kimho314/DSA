package boj;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ16948 {
    static FastReader SC = new FastReader();
    static int N;
    static boolean[][] VISITED;
    static int[][] MAP, DIST;
    static int[][] DIR = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) {
        N = SC.nextInt();
        int r1 = SC.nextInt();
        int c1 = SC.nextInt();
        int r2 = SC.nextInt();
        int c2 = SC.nextInt();

        VISITED = new boolean[N][N];
        MAP = new int[N][N];
        DIST = new int[N][N];

        bfs(r1, c1);

        int dist = DIST[r2][c2];
        if (dist == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(dist);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        VISITED[x][y] = true;

        while (!queue.isEmpty()) {
            x = queue.poll();
            y = queue.poll();


            for (int i = 0; i < DIR.length; i++) {
                int dx = x + DIR[i][0];
                int dy = y + DIR[i][1];

                if (dx < 0 || dy < 0 || dx >= N || dy >= N) {
                    continue;
                }
                if (VISITED[dx][dy]) {
                    continue;
                }

                queue.add(dx);
                queue.add(dy);
                DIST[dx][dy] = DIST[x][y] + 1;
                VISITED[dx][dy] = true;
            }
        }
    }
}
