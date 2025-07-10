package boj;

import java.util.ArrayList;

public class BOJ10026 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static char[][] MAP;
    private static boolean[][] VISITED;
    private static ArrayList<Integer> GROUP1, GROUP2;
    private static int CNT;
    private static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!VISITED[i][j]) {
                    CNT = 0;
                    dfs(i, j, MAP[i][j]);
                    GROUP1.add(CNT);
                }
            }
        }

        VISITED = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!VISITED[i][j]) {
                    CNT = 0;
                    dfs2(i, j, MAP[i][j]);
                    GROUP2.add(CNT);
                }
            }
        }

        System.out.println(GROUP1.size() + " " + GROUP2.size());
    }

    private static void dfs2(int y, int x, char color) {
        VISITED[y][x] = true;
        CNT++;

        for (int i = 0; i < 4; i++) {
            int dy = y + DIR[i][0];
            int dx = x + DIR[i][1];

            if (dx < 0 || dy < 0 || dx >= N || dy >= N) {
                continue;
            }
            if (VISITED[dy][dx]) {
                continue;
            }
            if (!isSame(MAP[dy][dx], color)) {
                continue;
            }

            dfs2(dy, dx, color);
        }
    }

    private static boolean isSame(char color1, char color2) {
        if ((color1 == 'R' || color1 == 'G') && (color2 == 'R' || color2 == 'G')) {
            return true;
        }
        if (color1 == 'B' && color2 == 'B') {
            return true;
        }
        return false;
    }

    private static void dfs(int y, int x, char color) {
        VISITED[y][x] = true;
        CNT++;

        for (int i = 0; i < 4; i++) {
            int dy = y + DIR[i][0];
            int dx = x + DIR[i][1];

            if (dx < 0 || dy < 0 || dx >= N || dy >= N) {
                continue;
            }
            if (VISITED[dy][dx]) {
                continue;
            }
            if (MAP[dy][dx] != color) {
                continue;
            }

            dfs(dy, dx, color);
        }
    }

    private static void input() {
        N = SC.nextInt();
        MAP = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = SC.next();
            for (int j = 0; j < N; j++) {
                MAP[i][j] = str.charAt(j);
            }
        }
        GROUP1 = new ArrayList<>();
        GROUP2 = new ArrayList<>();
        VISITED = new boolean[N][N];
    }
}
