package boj;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BOJ7576 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[][] BOX;
    private static boolean[][] VISITED;
    private static int[][] DIST;
    private static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        bfs();

        int res = -1;
        boolean isAllVisited = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (BOX[i][j] == -1) {
                    continue;
                }
                if (BOX[i][j] == 0) {
                    isAllVisited = false;
                    break;
                }
                if (BOX[i][j] == 1) {
                    res = Math.max(res, DIST[i][j]);
                }
            }

            if (!isAllVisited) {
                break;
            }
        }

        if (!isAllVisited) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    private static void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (BOX[i][j] == 1) {
                    q.add(i);
                    q.add(j);
                    DIST[i][j] = 0;
                    VISITED[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < 4; i++) {
                int dy = y + DIR[i][0];
                int dx = x + DIR[i][1];

                if (dy < 0 || dx < 0 || dy >= N || dx >= M) {
                    continue;
                }
                if (VISITED[dy][dx]) {
                    continue;
                }
                if (BOX[dy][dx] != 0) {
                    continue;
                }

                BOX[dy][dx] = 1;
                VISITED[dy][dx] = true;
                DIST[dy][dx] = DIST[y][x] + 1;
                q.add(dy);
                q.add(dx);
            }
        }
    }

    private static void input() {
        M = SC.nextInt();
        N = SC.nextInt();
        BOX = new int[N][M];
        VISITED = new boolean[N][M];
        DIST = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                BOX[i][j] = SC.nextInt();
            }
            Arrays.fill(DIST[i], -1);
        }
    }
}
