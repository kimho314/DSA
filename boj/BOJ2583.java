package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ2583 {
    static FastReader SC = new FastReader();
    static int M, N, K;
    static boolean[][] MAP;
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int CNT;
    static List<Integer> GROUP = new ArrayList<>();

    public static void main(String[] args) {
        M = SC.nextInt();
        N = SC.nextInt();
        K = SC.nextInt();
        MAP = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            int row1 = SC.nextInt();
            int col1 = SC.nextInt();
            int row2 = SC.nextInt();
            int col2 = SC.nextInt();

            for (int row = row1; row < row2; row++) {
                for (int col = col1; col < col2; col++) {
                    MAP[row][col] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!MAP[i][j]) {
                    CNT = 1;
                    bfs(i, j);
                    GROUP.add(CNT);
                }
            }
        }

        Collections.sort(GROUP);

        System.out.println(GROUP.size());
        System.out.println(GROUP.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static void bfs(int x, int y) {
        MAP[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int dx = x + DIR[i][0];
            int dy = y + DIR[i][1];

            if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                continue;
            }
            if (MAP[dx][dy]) {
                continue;
            }

            MAP[dx][dy] = true;
            CNT++;
            bfs(dx, dy);
        }
    }
}
