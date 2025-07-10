package boj;

import java.util.*;

public class BOJ11054 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }

    private static void solve() {
        int[][] dp = new int[N][2];
        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
                if (A[j] > A[i]) {
                    dp[i][1] = Math.max(dp[i][1], Math.max(dp[j][0] + 1, dp[j][1] + 1));
                }
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            // System.out.println(dp[i][0] + " " + dp[i][1]);
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(res);
    }
}
