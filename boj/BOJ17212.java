package boj;

public class BOJ17212 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i >= 2) {
                dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            }
            if (i >= 5) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
            if (i >= 7) {
                dp[i] = Math.min(dp[i], dp[i - 7] + 1);
            }
        }

        System.out.println(dp[N]);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
