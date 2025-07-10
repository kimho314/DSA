package boj;

import java.util.ArrayList;
import java.util.List;

public class BOJ1012 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[][] MAP;
    static int M, N, K, Q;
    static boolean[][] VISITED;
    static List<Integer> GROUP;
    static int GROUP_CNT;
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Q = sc.nextInt();
        while (Q > 0) {
            Q--;
            input();
            process();
            sb.append(GROUP.size()).append('\n');
        }
        System.out.println(sb);
    }

    private static void process() {
        GROUP = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!VISITED[i][j] && MAP[i][j] == 1) {
                    GROUP_CNT = 0;
                    dfs(i, j);
                    GROUP.add(GROUP_CNT);
                }
            }
        }
    }

    private static void dfs(int x, int y) {
        GROUP_CNT++;
        VISITED[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int dx = x + DIR[k][0];
            int dy = y + DIR[k][1];
            if (dx < 0 || dy < 0 || dx >= M || dy >= N) {
                continue;
            }
            if (VISITED[dx][dy]) {
                continue;
            }
            if (MAP[dx][dy] == 0) {
                continue;
            }

            dfs(dx, dy);
        }
    }

    private static void input() {
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        MAP = new int[M][N];
        VISITED = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            MAP[x][y] = 1;
        }
    }
}
