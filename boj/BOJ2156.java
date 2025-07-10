package boj;

public class BOJ2156 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] WINES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] dp = new int[N + 1];
        dp[1] = WINES[1];
        if (N >= 2) {
            dp[2] = WINES[1] + WINES[2];
        }

        for (int i = 3; i <= N; i++) {
            int case1 = dp[i - 1];
            int case2 = dp[i - 2] + WINES[i];
            int case3 = dp[i - 3] + WINES[i - 1] + WINES[i];
            dp[i] = Math.max(case1, Math.max(case2, case3));
        }

        System.out.println(dp[N]);
    }

    private static void input() {
        N = SC.nextInt();
        WINES = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            WINES[i] = SC.nextInt();
        }
    }
}
