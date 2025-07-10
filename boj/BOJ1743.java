package boj;

import java.util.ArrayList;

public class BOJ1743 {
    static FastReader SC = new FastReader();
    static int[][] MAP;
    static boolean[][] VISITED;
    static int SIZE;
    static ArrayList<Integer> SIZE_GROUP = new ArrayList<>();
    static int N, M, K;
    static int[][] DIR = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        K = SC.nextInt();
        MAP = new int[N + 1][M + 1];
        VISITED = new boolean[N + 1][M + 1];
        for (int i = 0; i < K; i++) {
            int r = SC.nextInt();
            int c = SC.nextInt();
            MAP[r][c] = 1;
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (MAP[i][j] == 1) {
                    SIZE = 0;
                    dfs(i, j);
                    SIZE_GROUP.add(SIZE);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (Integer size : SIZE_GROUP) {
            max = Math.max(size, max);
        }
        System.out.println(max);
    }

    private static void dfs(int y, int x) {
        VISITED[y][x] = true;
        ++SIZE;

        for (int i = 0; i < 4; i++) {
            int dy = y + DIR[i][0];
            int dx = x + DIR[i][1];

            if (dx < 0 || dy < 0 || dx > M || dy > N) {
                continue;
            }
            if (VISITED[dy][dx] || MAP[dy][dx] == 0) {
                continue;
            }

            dfs(dy, dx);
        }
    }
}
