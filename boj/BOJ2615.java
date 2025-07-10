package boj;

import java.util.*;

public class BOJ2615 {
    private static FastReader SC = new FastReader();
    private static int R, C;
    private static int[][] MAP;
    private static int[][] DIR = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        boolean isWin = false;
        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                if (MAP[i][j] == 0) {
                    continue;
                }
                isWin = check(i, j, MAP[i][j]);
                if (isWin) {
                    sb.append(MAP[i][j]).append("\n");
                    sb.append(i + 1).append(" ").append(j + 1);
                    System.out.println(sb);
                    return;
                }
            }
        }

        System.out.println(0);
    }

    private static boolean check(int x, int y, int value) {
        for (int i = 0; i < 4; i++) {
            int dx = x;
            int dy = y;
            int cnt = 1;

            while (true) {
                dx += DIR[i][0];
                dy += DIR[i][1];
                if (dx < 0 || dy < 0 || dx >= R || dy >= C) {
                    break;
                }
                if (MAP[dx][dy] == value) {
                    cnt++;
                } else {
                    break;
                }
            }

            dx = x;
            dy = y;

            while (true) {
                dx -= DIR[i][0];
                dy -= DIR[i][1];
                if (dx < 0 || dy < 0 || dx >= R || dy >= C) {
                    break;
                }
                if (MAP[dx][dy] == value) {
                    cnt++;
                } else {
                    break;
                }
            }

            if (cnt == 5) {
                return true;
            }
        }
        return false;
    }


    private static void input() {
        R = 19;
        C = 19;
        MAP = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }
    }
}
