package boj;

import java.util.ArrayList;

public class BOJ21938 {
    private static FastReader SC = new FastReader();
    private static int N, M, T;
    private static int[][] MAP;
    private static boolean[][] VISITED;
    private static int CNT;
    private static ArrayList<Integer> GROUP_CNT;
    private static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        transform();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!VISITED[i][j] && MAP[i][j] == 255) {
                    CNT = 0;
                    dfs(i, j);
                    GROUP_CNT.add(CNT);
                }
            }
        }

        System.out.println(GROUP_CNT.size());
    }

    private static void dfs(int y, int x) {
        VISITED[y][x] = true;
        ++CNT;

        for (int i = 0; i < 4; i++) {
            int dy = y + DIR[i][0];
            int dx = x + DIR[i][1];

            if (dy < 0 || dx < 0 || dy >= N || dx >= M) {
                continue;
            }
            if (VISITED[dy][dx]) {
                continue;
            }
            if (MAP[dy][dx] == 0) {
                continue;
            }

            VISITED[dy][dx] = true;
            dfs(dy, dx);
        }
    }

    private static void transform() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (MAP[i][j] >= T) {
                    MAP[i][j] = 255;
                }
                else {
                    MAP[i][j] = 0;
                }
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        MAP = new int[N][M];
        VISITED = new boolean[N][M];
        GROUP_CNT = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int r = SC.nextInt();
                int g = SC.nextInt();
                int b = SC.nextInt();
                MAP[i][j] = (r + g + b) / 3;
            }
        }
        T = SC.nextInt();
    }
}
