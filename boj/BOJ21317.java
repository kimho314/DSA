package boj;

import java.util.*;

public class BOJ21317 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static int[][] E;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[][] dp = new int[N + 1][2];

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i][0], dp[i - 1][0] + E[i - 1][0]);
            dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + E[i - 1][0]);
            if (i >= 3) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 2][0] + E[i - 2][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 2][1] + E[i - 2][1]);
            }
            if (i >= 4) {
                dp[i][1] = Math.min(dp[i][1], dp[i - 3][0] + K);
            }
        }

        // for (int i = 1; i <= N; i++) {
        // System.out.println(dp[i][0] + " " + dp[i][1]);
        // }

        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }

    private static void input() {
        N = SC.nextInt();
        E = new int[N + 1][2];
        for (int i = 1; i <= N - 1; i++) {
            int e1 = SC.nextInt();
            int e2 = SC.nextInt();
            E[i][0] = e1;
            E[i][1] = e2;
        }
        E[0][1] = Integer.MAX_VALUE;
        K = SC.nextInt();
    }
}
