package boj;

import java.util.*;

public class BOJ16439 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[][] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;

        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    int sum = 0;
                    for (int t = 0; t < N; t++) {
                        int max = Math.max(A[t][i], Math.max(A[t][j], A[t][k]));
                        sum += max;
                    }
                    res = Math.max(res, sum);
                }
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = SC.nextInt();
            }
        }
    }
}
