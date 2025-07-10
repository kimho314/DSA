package boj;

public class BOJ10844 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int MOD = 1_000_000_000;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long[][] dp = new long[N + 1][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] % MOD;
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] % MOD) + (dp[i - 1][j + 1] % MOD);
            }
            dp[i][9] = dp[i - 1][8] % MOD;
        }

        long total = 0;
        for (int i = 1; i <= 9; i++) {
            total = (total + dp[N][i]) % MOD;
        }
        System.out.println(total);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
