package boj;

import java.util.ArrayList;
import java.util.List;

public class BOJ2468 {
    static FastReader SC = new FastReader();
    static int N;
    static int[][] MAP;
    static boolean[][] VISITED;
    static int CNT, MAX_CNT = 0;
    static List<Integer> CNT_GROUP;
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        N = SC.nextInt();
        MAP = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }

        for (int h = 0; h <= 100; h++) {
            CNT_GROUP = new ArrayList<>();
            VISITED = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (MAP[i][j] > h && !VISITED[i][j]) {
                        CNT = 0;
                        dfs(i, j, h);
                        CNT_GROUP.add(CNT);
                    }
                }
            }
            MAX_CNT = Math.max(MAX_CNT, CNT_GROUP.size());
        }
        System.out.println(MAX_CNT);
    }


    private static void dfs(int y, int x, int h) {
        VISITED[y][x] = true;
        CNT++;

        for (int i = 0; i < 4; i++) {
            int dy = y + DIR[i][0];
            int dx = x + DIR[i][1];

            if (dy < 0 || dx < 0 || dy >= N || dx >= N) {
                continue;
            }
            if (MAP[dy][dx] <= h) {
                continue;
            }
            if (VISITED[dy][dx]) {
                continue;
            }

            dfs(dy, dx, h);
        }
    }
}
