package boj;

import java.util.Arrays;

public class BOJ11057 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[][] dp = new int[1_000 + 1][10];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= 1_000; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += (dp[i - 1][k] % 10_007);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += dp[N][i];
        }
        System.out.println(res % 10_007);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
