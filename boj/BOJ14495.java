package boj;

public class BOJ14495 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long[] dp = new long[117];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= 116; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }

        System.out.println(dp[N]);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
