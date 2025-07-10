package boj;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ2178 {
    static FastReader sc = new FastReader();
    static int N, M;
    static int[][] MAP;
    static int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] DIST;
    static boolean[][] VISIT;

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        MAP = new int[N][M];
        DIST = new int[N][M];
        VISIT = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] split = sc.next().split("");
            for (int j = 0; j < M; j++) {
                MAP[i][j] = Integer.parseInt(split[j]);
            }
        }

        bfs(0, 0);
        System.out.println(DIST[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                DIST[i][j] = -1;
            }
        }

        Queue<Integer> needVisit = new LinkedList<>();
        needVisit.add(x);
        needVisit.add(y);
        DIST[x][y] = 1;
        VISIT[x][y] = true;

        while (!needVisit.isEmpty()) {
            x = needVisit.poll();
            y = needVisit.poll();

            for (int i = 0; i < 4; i++) {
                int dx = x + DIR[i][0];
                int dy = y + DIR[i][1];

                if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }
                if (MAP[dx][dy] == 0) {
                    continue;
                }
                if (VISIT[dx][dy]) {
                    continue;
                }

                needVisit.add(dx);
                needVisit.add(dy);
                VISIT[dx][dy] = true;
                DIST[dx][dy] = DIST[x][y] + 1;
            }
        }
    }
}
