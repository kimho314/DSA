package boj;

import java.util.*;

public class BOJ14940 {
    private static FastReader SC = new FastReader();
    private static int[][] MAP;
    private static boolean[][] VISITED;
    private static int[][] DIST;
    private static int N, M;
    private static int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int startY = -1;
        int startX = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (MAP[i][j] == 2) {
                    startY = i;
                    startX = j;
                }
                if (MAP[i][j] == 0) {
                    DIST[i][j] = 0;
                }
            }
        }


        bfs(startY, startX);

        int[][] res = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (MAP[i][j] == 0) {
                    res[i][j] = 0;
                } else if (MAP[i][j] != 0 && DIST[i][j] == -1) {
                    res[i][j] = -1;
                } else {
                    res[i][j] = DIST[i][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(DIST[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int y, int x) {
        VISITED[y][x] = true;
        DIST[y][x] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);

        while (!q.isEmpty()) {
            int y2 = q.poll();
            int x2 = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = y2 + DIR[i][0];
                int dx = x2 + DIR[i][1];
                if (dy < 0 || dx < 0 || dy >= N || dx >= M) {
                    continue;
                }
                if (VISITED[dy][dx] || MAP[dy][dx] == 0) {
                    continue;
                }

                VISITED[dy][dx] = true;
                DIST[dy][dx] = DIST[y2][x2] + 1;
                q.add(dy);
                q.add(dx);
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        MAP = new int[N][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }
        VISITED = new boolean[N][M];
        DIST = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                DIST[i][j] = -1;
            }
        }
    }
}
