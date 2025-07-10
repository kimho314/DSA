package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ1926 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[][] MAP;
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] VISITED;
    static List<Integer> PAINTS = new ArrayList<>();
    static int CNT = 0;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        VISITED = new boolean[N][M];
        MAP = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (MAP[i][j] == 1 && !VISITED[i][j]) {
                    CNT = 0;
                    dfs(i, j);
                    PAINTS.add(CNT);
                }
            }
        }

        if (PAINTS.isEmpty()) {
            System.out.println(0);
            System.out.println(0);
        }
        else {
            System.out.println(PAINTS.size());
            Collections.sort(PAINTS);
            System.out.println(PAINTS.get(PAINTS.size() - 1));
        }
    }

    private static void dfs(int y, int x) {
        VISITED[y][x] = true;
        CNT++;

        for (int i = 0; i < 4; i++) {
            int dy = y + DIR[i][0];
            int dx = x + DIR[i][1];

            if (dy < 0 || dx < 0 || dy >= N || dx >= M) {
                continue;
            }
            if (VISITED[dy][dx] || MAP[dy][dx] == 0) {
                continue;
            }

            dfs(dy, dx);
        }
    }
}
