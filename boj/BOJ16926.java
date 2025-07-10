package boj;

import java.util.*;

public class BOJ16926 {
    private static FastReader SC = new FastReader();
    private static int N, M, R;
    private static int[][] MAP;
    private static int[][] RES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        R = SC.nextInt();
        MAP = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }
        RES = new int[N][M];
    }

    private static void solve() {
        for (int cnt = 0; cnt < R; cnt++) {
            rotate();
            copy();
            // System.out.println(cnt);
            // print();
        }

        print();
    }

    private static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                MAP[i][j] = RES[i][j];
            }
        }
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(RES[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate() {
        int t = Math.min(N, M) / 2;
        int y = 0;
        int x = 0;
        int r = N - 1;
        int c = M - 1;

        while (t > 0) {
            int dy = y;
            int dx = x;
            for (int i = 0; i < r; i++) {
                RES[dy + 1][dx] = MAP[dy++][dx];
            }
            for (int i = 0; i < c; i++) {
                RES[dy][dx + 1] = MAP[dy][dx++];
            }
            for (int i = 0; i < r; i++) {
                RES[dy - 1][dx] = MAP[dy--][dx];
            }
            for (int i = 0; i < c; i++) {
                RES[dy][dx - 1] = MAP[dy][dx--];
            }

            t--;
            r -= 2;
            c -= 2;
            y++;
            x++;
        }
    }
}
