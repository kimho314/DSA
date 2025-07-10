package boj;

import java.util.*;

public class BOJ17836 {
    private static FastReader SC = new FastReader();
    private static int[][] MAP;
    private static boolean[][] VISITED;
    private static int N, M, T;
    private static int[][] DIST;
    private static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        T = SC.nextInt();
        MAP = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }
        VISITED = new boolean[N][M];
        DIST = new int[N][M];
    }

    private static void solve() {
        init();
        bfs(0, 0, false);

        int res1 = DIST[N - 1][M - 1];

        int startY = -1;
        int startX = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (MAP[i][j] == 2) {
                    startY = i;
                    startX = j;
                    break;
                }
            }
        }

        int dist2 = DIST[startY][startX];
        if (res1 == -1 && dist2 == -1) {
            System.out.println("Fail");
        } else {
            init();
            bfs(startY, startX, true);

            int finalDist2 = dist2 + DIST[N - 1][M - 1];
            if (res1 == -1 && dist2 != -1 && finalDist2 <= T) {
                System.out.println(finalDist2);
            } else if (dist2 == -1 && res1 != -1 && res1 <= T) {
                System.out.println(res1);
            } else {
                if (res1 != -1 && dist2 != -1 && res1 <= T && finalDist2 <= T) {
                    System.out.println(Math.min(res1, finalDist2));
                } else {
                    if (res1 != -1 && res1 <= T && finalDist2 > T) {
                        System.out.println(res1);
                    } else if (res1 > T && dist2 != -1 && finalDist2 <= T) {
                        System.out.println(finalDist2);
                    } else {
                        System.out.println("Fail");
                    }
                }

            }
        }
    }

    private static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                DIST[i][j] = -1;
                VISITED[i][j] = false;
            }
        }
    }

    private static void bfs(int y, int x, boolean isPass) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        q.add(x);
        VISITED[y][x] = true;
        DIST[y][x] = 0;

        while (!q.isEmpty()) {
            int tmpY = q.poll();
            int tmpX = q.poll();
            for (int i = 0; i < 4; i++) {
                int dy = tmpY + DIR[i][0];
                int dx = tmpX + DIR[i][1];
                if (dy < 0 || dx < 0 || dy >= N || dx >= M) {
                    continue;
                }
                if (VISITED[dy][dx]) {
                    continue;
                }
                if (!isPass && MAP[dy][dx] == 1) {
                    continue;
                }

                VISITED[dy][dx] = true;
                DIST[dy][dx] = DIST[tmpY][tmpX] + 1;
                q.add(dy);
                q.add(dx);
            }
        }
    }
}
