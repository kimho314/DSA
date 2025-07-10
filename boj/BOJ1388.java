package boj;

import java.util.ArrayList;
import java.util.List;

public class BOJ1388 {
    static FastReader SC = new FastReader();
    static int N, M;
    static String[][] MAP;
    static boolean[][] VISITED;
    static int CNT = 0;
    static List<Integer> GROUPS = new ArrayList<>();
    static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();

        MAP = new String[N][M];
        VISITED = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = SC.nextLine();
            for (int j = 0; j < M; j++) {
                MAP[i][j] = String.valueOf(input.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!VISITED[i][j]) {
                    CNT = 0;
                    dfs(i, j);
                    GROUPS.add(CNT);
                }
            }
        }
        System.out.println(GROUPS.size());
    }

    private static void dfs(int y, int x) {
        VISITED[y][x] = true;
        CNT++;

        if (MAP[y][x].equals("-")) {
            for (int i = 0; i < 2; i++) {
                int dy = y + DIR[i][0];
                int dx = x + DIR[i][1];

                if (dy >= N || dx >= M || dy < 0 || dx < 0) {
                    continue;
                }
                if (MAP[dy][dx].equals("|") || VISITED[dy][dx]) {
                    continue;
                }

                dfs(dy, dx);
            }
        }
        else {
            for (int i = 2; i < 4; i++) {
                int dy = y + DIR[i][0];
                int dx = x + DIR[i][1];

                if (dy >= N || dx >= M || dy < 0 || dx < 0) {
                    continue;
                }
                if (MAP[dy][dx].equals("-") || VISITED[dy][dx]) {
                    continue;
                }

                dfs(dy, dx);
            }
        }
    }
}
