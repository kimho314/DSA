package boj;

import java.util.ArrayList;
import java.util.List;

public class BOJ14716 {
    static FastReader SC = new FastReader();
    static int N, M;
    static List<Integer> CNT_GROUP = new ArrayList<>();
    static int[][] MAP;
    static int CNT;
    static boolean[][] VISITED;
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};


    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        MAP = new int[N][M];
        VISITED = new boolean[N][M];
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
                    CNT_GROUP.add(CNT);
                }
            }
        }
        System.out.println(CNT_GROUP.size());
    }

    private static void dfs(int y, int x) {
        VISITED[y][x] = true;
        CNT++;

        for (int i = 0; i < 8; i++) {
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
