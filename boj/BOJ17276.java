package boj;

import java.util.*;

public class BOJ17276 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        while (T > 0) {
            T--;
            int n = SC.nextInt();
            int d = SC.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = SC.nextInt();
                }
            }

            int limit = Math.abs(d) / 45;
            int[][] res = new int[n][n];
            if (d > 0) {
                for (int i = 1; i <= limit; i++) {
                    res = new int[n][n];
                    moveClockWise(n, map, res);
                    copy(res, map, n);
                }
            }
            if (d < 0) {
                for (int i = 1; i <= limit; i++) {
                    res = new int[n][n];
                    moveCounterClockWise(n, map, res);
                    copy(res, map, n);
                }
            }
            if (d == 0) {
                copy(map, res, n);
            }
            print(res, n);
        }
        System.out.println(SB);
    }

    private static void copy(int[][] src, int[][] dest, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dest[i][j] = src[i][j];
            }
        }
    }

    private static void print(int[][] res, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                SB.append(res[i][j]).append(" ");
            }
            SB.append("\n");
        }
    }

    private static void moveCounterClockWise(int n, int[][] map, int[][] res) {
        for (int i = 0; i < n; i++) {
            res[(n + 1) / 2 - 1][i] = map[i][i];
        }
        for (int i = 0; i < n; i++) {
            res[i][i] = map[i][(n + 1) / 2 - 1];
        }
        for (int i = 0; i < n; i++) {
            res[i][(n + 1) / 2 - 1] = map[i][n - i - 1];
        }
        for (int i = 0; i < n; i++) {
            res[n - i - 1][i] = map[(n + 1) / 2 - 1][i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == 0) {
                    res[i][j] = map[i][j];
                }
            }
        }
    }

    private static void moveClockWise(int n, int[][] map, int[][] res) {
        for (int i = 0; i < n; i++) {
            res[i][(n + 1) / 2 - 1] = map[i][i];
        }
        for (int i = 0; i < n; i++) {
            res[i][n - i - 1] = map[i][(n + 1) / 2 - 1];
        }
        for (int i = 0; i < n; i++) {
            res[(n + 1) / 2 - 1][n - i - 1] = map[i][n - i - 1];
        }
        for (int i = 0; i < n; i++) {
            res[i][i] = map[(n + 1) / 2 - 1][i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == 0) {
                    res[i][j] = map[i][j];
                }
            }
        }
    }

    private static void input() {
        T = SC.nextInt();
    }
}
