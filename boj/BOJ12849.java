package boj;

public class BOJ12849 {
    private static FastReader SC = new FastReader();
    private static int D;
    private static int DIV = 1_000_000_007;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long[][] dp = new long[D + 1][8];
        dp[0][0] = 1;

        for (int i = 0; i < D; i++) {
            dp[i + 1][0] = (dp[i][1] + dp[i][2]) % DIV;
            dp[i + 1][1] = (dp[i][0] + dp[i][2] + dp[i][3]) % DIV;
            dp[i + 1][2] = (dp[i][0] + dp[i][1] + dp[i][3] + dp[i][5]) % DIV;
            dp[i + 1][3] = (dp[i][1] + dp[i][2] + dp[i][4] + dp[i][5]) % DIV;
            dp[i + 1][4] = (dp[i][3] + dp[i][5] + dp[i][6]) % DIV;
            dp[i + 1][5] = (dp[i][2] + dp[i][3] + dp[i][4] + dp[i][7]) % DIV;
            dp[i + 1][6] = (dp[i][4] + dp[i][7]) % DIV;
            dp[i + 1][7] = (dp[i][5] + dp[i][6]) % DIV;
        }

        System.out.println(dp[D][0]);
    }

    private static void input() {
        D = SC.nextInt();
    }
}
