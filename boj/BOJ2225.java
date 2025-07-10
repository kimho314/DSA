package boj;

import java.util.Arrays;

public class BOJ2225 {
    private static FastReader SC = new FastReader();
    private static int N, K;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[][] dp = new int[K + 1][N + 1];
        Arrays.fill(dp[1], 1);
        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                dp[i][j] %= 1_000_000_000;
            }
        }

        System.out.println(dp[K][N]);
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
    }
}
