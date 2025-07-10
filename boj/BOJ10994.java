package boj;

import java.util.*;

public class BOJ10994 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int size = 4 * (N - 1) + 1;
        char[][] pan = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                pan[i][j] = ' ';
            }
        }

        draw(0, pan, N);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(pan[i][j]);
            }
            System.out.println();
        }
    }

    private static void draw(int start, char[][] arr, int n) {
        if (n <= 0) {
            return;
        }

        int cnt = 4 * (n - 1) + 1;
        for (int i = start; i < start + cnt; i++) {
            arr[start][i] = '*';
            arr[i][start] = '*';
            arr[start + cnt - 1][i] = '*';
            arr[i][start + cnt - 1] = '*';
        }
        draw(start + 2, arr, n - 1);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
